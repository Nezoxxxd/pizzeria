package com.modsen.pizzeria.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modsen.pizzeria.config.SecurityUser;
import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.domain.RoleName;
import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.error.ErrorMessages;
import com.modsen.pizzeria.exception.DuplicateResourceException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.mappers.UserMapper;
import com.modsen.pizzeria.redis.RedisService;
import com.modsen.pizzeria.repository.RoleRepository;
import com.modsen.pizzeria.repository.UserRepository;
import com.modsen.pizzeria.service.AuthenticationService;
import com.modsen.pizzeria.service.JwtService;
import com.modsen.pizzeria.token.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RedisService redisService;
    private final UserMapper userMapper;

    @Override
    public AuthenticationResponse register(CreateUserRequest request) throws JsonProcessingException {
        checkUserExistence(request.email());

        Role defaultRole = findRoleByName(RoleName.CUSTOMER);
        UserDetails userDetails = buildUser(request, defaultRole);

        UserResponse savedUser = userMapper.toUserResponse(userRepository.save(((SecurityUser)userDetails).getUser()));
        String accessToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);
        saveUserToken(savedUser, accessToken); //!!!!!!!!!!!

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws JsonProcessingException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        User user = findUserByEmail(request.email());
        UserDetails userDetails = new SecurityUser(user);
        String accessToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);
        revokeAllUserTokens(user);
        saveUserToken(userMapper.toUserResponse(user), accessToken);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        final AuthenticationResponse authResponse;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserEmail(refreshToken);

        if (userEmail != null) {
            User user = findUserByEmail(userEmail);
            UserDetails userDetails = new SecurityUser(user);

            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                String newAccessToken = jwtService.generateToken(userDetails);
                String newRefreshToken = jwtService.generateRefreshToken(userDetails);
                revokeAllUserTokens(user);
                saveUserToken(userMapper.toUserResponse(user), newAccessToken);

                authResponse = AuthenticationResponse.builder()
                        .accessToken(newAccessToken)
                        .refreshToken(newRefreshToken)
                        .build();

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    private void saveUserToken(UserResponse user, String accessToken) throws JsonProcessingException {
        Token token = new Token(accessToken,false,false);
        redisService.saveToken(user.id(), token);
    }



    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = RedisService.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        RedisService.saveAll(validUserTokens);
    }

    private Role findRoleByName(RoleName roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.ROLE_NOT_FOUND_MESSAGE, roleName)));
    }

    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.USER_NOT_FOUND_MESSAGE, email)));
    }

    private void checkUserExistence(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateResourceException(String.format(ErrorMessages.DUPLICATE_RESOURCE_MESSAGE, "User", "email"));
        }
    }

    private UserDetails buildUser(CreateUserRequest request, Role role) {
        User user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .gender(request.gender())
                .birthDate(request.birthDate())
                .role(role)
                .build();

        return new SecurityUser(user);
    }
}
