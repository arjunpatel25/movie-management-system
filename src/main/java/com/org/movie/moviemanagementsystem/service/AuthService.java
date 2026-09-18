package com.org.movie.moviemanagementsystem.service;

import com.org.movie.moviemanagementsystem.dto.AuthResoponseDto;
import com.org.movie.moviemanagementsystem.dto.LoginRequestDto;
import com.org.movie.moviemanagementsystem.dto.RegisterRequestDto;

public interface AuthService {
    String register(RegisterRequestDto requestDto);
    AuthResoponseDto login(LoginRequestDto requestDto);
}
