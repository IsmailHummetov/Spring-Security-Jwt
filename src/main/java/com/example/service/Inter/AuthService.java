package com.example.service.Inter;

import com.example.dto.AuthResponseDto;
import com.example.dto.LoginDto;
import com.example.dto.RegisterDto;

public interface AuthService {
    AuthResponseDto register(RegisterDto register);

    AuthResponseDto login(LoginDto login);
}
