package com.org.movie.moviemanagementsystem.controller;

import com.org.movie.moviemanagementsystem.dto.AuthResoponseDto;
import com.org.movie.moviemanagementsystem.dto.LoginRequestDto;
import com.org.movie.moviemanagementsystem.dto.RegisterRequestDto;
import com.org.movie.moviemanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto requestDto) {
        return new ResponseEntity<>(authService.register(requestDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResoponseDto> login(@RequestBody LoginRequestDto requestDto) {
        return new ResponseEntity<>(authService.login(requestDto), HttpStatus.OK);
    }
}
