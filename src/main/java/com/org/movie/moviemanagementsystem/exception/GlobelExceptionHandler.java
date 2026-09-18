package com.org.movie.moviemanagementsystem.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobelExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerMovieNotFoundException(MovieNotFoundException ex , HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setStatuscode(HttpStatus.NOT_FOUND.value());
        response.setPath(request.getRequestURI());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
