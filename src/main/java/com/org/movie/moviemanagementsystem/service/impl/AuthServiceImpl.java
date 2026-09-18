package com.org.movie.moviemanagementsystem.service.impl;

import com.org.movie.moviemanagementsystem.dto.AuthResoponseDto;
import com.org.movie.moviemanagementsystem.dto.LoginRequestDto;
import com.org.movie.moviemanagementsystem.dto.RegisterRequestDto;
import com.org.movie.moviemanagementsystem.entity.User;
import com.org.movie.moviemanagementsystem.repository.UserRepository;
import com.org.movie.moviemanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setRole(requestDto.getRole());


        userRepository.save(user);

        return "User registered successfully";

    }

    @Override
    public AuthResoponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }
        return new AuthResoponseDto("Login Successful");
    }
}


