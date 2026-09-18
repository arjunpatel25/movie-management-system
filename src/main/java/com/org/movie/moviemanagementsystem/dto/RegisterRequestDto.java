package com.org.movie.moviemanagementsystem.dto;

import com.org.movie.moviemanagementsystem.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
