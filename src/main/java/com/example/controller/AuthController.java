package com.example.controller;

import com.example.dto.AuthResponseDto;
import com.example.dto.LoginDto;
import com.example.dto.RegisterDto;
import com.example.repository.UserRepository;
import com.example.service.Inter.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if (userRepository.existsByUsername(registerDto.getUsername())){
            return ResponseEntity.ok("This Username is already used");
        }
        return ResponseEntity.ok("User registered successfully"+"\nToken: "
                +authService.register(registerDto).getAccessToken());
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(authService.login(loginDto));
    }
}
