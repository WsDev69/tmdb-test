package com.spintech.tmdb.converter;

import com.spintech.tmdb.dto.controller.ClientMovie;
import com.spintech.tmdb.entity.Movie;

import java.util.function.Function;

public class RepositoryMovieToClientMovie implements Function<Movie, ClientMovie> {
    @Override
    public ClientMovie apply(Movie movie) {
        return ClientMovie
                .builder()
                .name(movie.getName())
                .description(movie.getDescription())
                .build();
    }
}
