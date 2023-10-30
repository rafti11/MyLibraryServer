package com.example.library.config;

import com.example.library.data.ClientRepository;
import com.example.library.model.request.AuthenticateRequest;
import com.example.library.model.request.AuthenticationResponse;
import com.example.library.model.request.RegisterRequest;
import com.example.library.model.user.Client;
import com.example.library.model.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        Client client = Client.builder()
                .email(request.getEmail())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(Role.CLIENT)
                .build();
        clientRepository.save(client);
        String token = jwtService.generateToken(client);
        return AuthenticationResponse.builder().token(token).build();

    }

    public AuthenticationResponse authenticate(AuthenticateRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                

        // Todo: Check exception later
        Client client = clientRepository.findByEmail(request.getEmail()).orElseThrow();

        String token = jwtService.generateToken(client);
        return AuthenticationResponse.builder().userID(client.getId()).token(token).build();

    }

}
