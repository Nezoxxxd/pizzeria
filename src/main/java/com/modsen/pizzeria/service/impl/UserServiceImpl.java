package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.aspect.annotation.EmailMatchOrAdminAccess;
import com.modsen.pizzeria.config.SecurityUser;
import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import com.modsen.pizzeria.error.ErrorMessages;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.mapper.UserMapper;
import com.modsen.pizzeria.repository.UserRepository;
import com.modsen.pizzeria.service.JwtService;
import com.modsen.pizzeria.service.UserService;
import com.modsen.pizzeria.token.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    @EmailMatchOrAdminAccess
    public UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User existingUser = findUserByIdOrThrow(id);
        userMapper.updateUserFromRequest(updateUserRequest, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    @EmailMatchOrAdminAccess
    public void deleteUser(Long id) {
        User user = findUserByIdOrThrow(id);
        userRepository.deleteById(id);
    }

    @Override
    @EmailMatchOrAdminAccess
    public UserResponse getUserById(Long id) {
        User user = findUserByIdOrThrow(id);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse me(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwtToken;
        final String userEmail;
        User user = null;

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }

        jwtToken = authHeader.substring(7);
        userEmail = jwtService.extractUserEmail(jwtToken);

        if(userEmail != null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            boolean isTokenValid = tokenRepository.findByToken(jwtToken)
                    .map(t -> !t.isExpired() || !t.isRevoked())
                    .orElse(false);

            if(jwtService.isTokenValid(jwtToken, userDetails) && isTokenValid) {
                user = findUserByEmail(userEmail);

            }
        }

        return userMapper.toUserResponse(user);
    }

    private User findUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, "User", id)));
    }

    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.USER_NOT_FOUND_MESSAGE, email)));
    }
}
