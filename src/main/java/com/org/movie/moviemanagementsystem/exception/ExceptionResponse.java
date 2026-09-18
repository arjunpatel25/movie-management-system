package com.org.movie.moviemanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String message;
    private int statuscode;
    private LocalDateTime timestamp;
    private String path;
}
