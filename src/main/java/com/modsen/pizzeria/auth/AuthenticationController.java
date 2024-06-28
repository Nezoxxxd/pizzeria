package com.modsen.pizzeria.auth;

import com.modsen.pizzeria.swagger.AuthenticationApi;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public AuthenticationResponse register(
            @RequestBody CreateUserRequest request
    ) {
        return service.register(request);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return service.authenticate(request);
    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

}
