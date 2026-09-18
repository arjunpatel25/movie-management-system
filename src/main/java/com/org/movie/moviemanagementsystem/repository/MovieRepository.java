package com.org.movie.moviemanagementsystem.repository;

import com.org.movie.moviemanagementsystem.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
