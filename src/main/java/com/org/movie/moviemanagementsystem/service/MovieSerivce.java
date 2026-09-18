package com.org.movie.moviemanagementsystem.service;

import com.org.movie.moviemanagementsystem.dto.MovieRequestDto;
import com.org.movie.moviemanagementsystem.dto.MovieResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieSerivce {
    MovieResponseDto saveMovie(MovieRequestDto movieRequestDto);

    List<MovieResponseDto> getAllMovies();

    MovieResponseDto getMovieById(Integer id);

    MovieResponseDto updateMovie(MovieRequestDto requestDto);

    void deleteMovie(Integer id);
}
