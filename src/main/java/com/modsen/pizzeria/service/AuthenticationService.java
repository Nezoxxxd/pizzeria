package com.modsen.pizzeria.service;

import com.modsen.pizzeria.auth.AuthenticationRequest;
import com.modsen.pizzeria.auth.AuthenticationResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    AuthenticationResponse register(CreateUserRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}
