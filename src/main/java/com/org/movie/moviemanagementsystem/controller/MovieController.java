package com.org.movie.moviemanagementsystem.controller;

import com.org.movie.moviemanagementsystem.dto.MovieRequestDto;
import com.org.movie.moviemanagementsystem.dto.MovieResponseDto;
import com.org.movie.moviemanagementsystem.service.MovieSerivce;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movie Controller", description = "Controller for managing movies")
public class MovieController {
    private final MovieSerivce movieSerivce;
    public MovieController(MovieSerivce movieSerivce) {
        this.movieSerivce = movieSerivce;
    }
    @Operation(summary = "Create a new movie")
    @PostMapping
    public ResponseEntity<MovieResponseDto> saveMovie(@RequestBody MovieRequestDto requestDto) {
        return new ResponseEntity<>(movieSerivce.saveMovie(requestDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Get all movies")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movies fetched successfully"),
            @ApiResponse(responseCode = "404", description = "No movies found")
    })
    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return new ResponseEntity<>(movieSerivce.getAllMovies(), HttpStatus.OK);
    }
    @Operation(summary = "Get movie by id")
    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200",description = "Movie found successfully")
    @ApiResponse(responseCode = "404",description = "Movie not found"
    )
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable Integer id) {
        return new ResponseEntity<>(movieSerivce.getMovieById(id), HttpStatus.OK);
    }
    @Operation(summary = "Update a movie")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movie updated successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "400", description = "Invalid movie data")
    })
    @PutMapping("{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable Integer id, @RequestBody MovieRequestDto requestDto) {
        return new ResponseEntity<>(movieSerivce.updateMovie(requestDto), HttpStatus.OK);
    }
    @Operation(summary ="Delete a movie" )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movie deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    @DeleteMapping
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {
        movieSerivce.deleteMovie(id);
        return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
    }
}
