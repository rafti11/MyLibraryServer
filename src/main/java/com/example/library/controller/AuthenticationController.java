package com.example.library.controller;

import com.example.library.config.AuthenticationService;
import com.example.library.model.request.AuthenticateRequest;
import com.example.library.model.request.AuthenticationResponse;
import com.example.library.model.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authenticationService.register(request));

    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request) {

        return ResponseEntity.ok(authenticationService.authenticate(request));

    }

    @GetMapping("istokenvalid")
    public ResponseEntity<HttpStatusCode> isTokenValid() {
        return ResponseEntity.ok(HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }
    
}
