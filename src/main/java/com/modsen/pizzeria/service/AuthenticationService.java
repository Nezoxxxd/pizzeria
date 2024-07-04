package com.modsen.pizzeria.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.modsen.pizzeria.auth.AuthenticationRequest;
import com.modsen.pizzeria.auth.AuthenticationResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(CreateUserRequest request) throws JsonProcessingException;

    AuthenticationResponse authenticate(AuthenticationRequest request) throws JsonProcessingException;

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
