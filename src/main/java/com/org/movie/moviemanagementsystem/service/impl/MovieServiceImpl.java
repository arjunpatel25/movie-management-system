package com.org.movie.moviemanagementsystem.service.impl;

import com.org.movie.moviemanagementsystem.dto.MovieRequestDto;
import com.org.movie.moviemanagementsystem.dto.MovieResponseDto;
import com.org.movie.moviemanagementsystem.entity.Movie;
import com.org.movie.moviemanagementsystem.exception.MovieNotFoundException;
import com.org.movie.moviemanagementsystem.repository.MovieRepository;
import com.org.movie.moviemanagementsystem.service.MovieSerivce;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieSerivce {
    public final MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    private Movie toEntity(MovieRequestDto requestDto) {

        Movie movie = new Movie();
        movie.setName(requestDto.getName());
        movie.setGenre(requestDto.getGenre());
        movie.setTitle(requestDto.getTitle());
        movie.setReleaseYear(requestDto.getReleaseYear());
        movie.setRating(requestDto.getRating());
        movie.setLanguage(requestDto.getLanguage());
        movie.setDirector(requestDto.getDirector());
        movie.setCast(requestDto.getCast());
        movie.setDescription(requestDto.getDescription());
        return movie;

    }
    private MovieResponseDto toResponseDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();

        responseDto.setId(movie.getId());
        responseDto.setTitle(movie.getTitle());
        responseDto.setGenre(movie.getGenre());
        responseDto.setName(movie.getName());
        responseDto.setCast(movie.getCast());
       responseDto.setDirector(movie.getDirector());
       responseDto.setDescription(movie.getDescription());
       responseDto.setLanguage(movie.getLanguage());
       responseDto.setRating(movie.getRating());
       responseDto.setReleaseYear(movie.getReleaseYear());
       return responseDto;
    }

    @Override
    public MovieResponseDto saveMovie(MovieRequestDto movieRequestDto) {
        Movie movie = toEntity(movieRequestDto);
        Movie savedMovie = movieRepository.save(movie);

        MovieResponseDto movieResponseDto = toResponseDto(savedMovie);

        return movieResponseDto;
    }

    @Override
    public List<MovieResponseDto> getAllMovies() {

        return movieRepository.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public MovieResponseDto getMovieById(Integer id) {

        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isEmpty()) {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
        return toResponseDto(movie.get());

    }

    @Override
    public MovieResponseDto updateMovie(MovieRequestDto requestDto) {
        Movie movie = toEntity(requestDto);
        Movie updatedMovie = movieRepository.save(movie);
        return toResponseDto(updatedMovie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);

    }

}
