package com.org.movie.moviemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private Integer id;
    private String title;
    private String name;
    private String genre;
    private Integer releaseYear;
    private Double rating;
    private String language;
    private String director;
    private String cast;
    private String description;
}
