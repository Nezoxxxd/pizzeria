package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.config.SecurityUser;
import com.modsen.pizzeria.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SecurityUser(
                userRepository.findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User not found"))
        );
    }
}
