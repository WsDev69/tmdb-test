package com.spintech.tmdb.converter;

import com.spintech.tmdb.dto.controller.ClientActor;
import com.spintech.tmdb.dto.controller.ClientMovie;
import com.spintech.tmdb.dto.controller.MovieWithActors;
import com.spintech.tmdb.entity.Actor;
import com.spintech.tmdb.entity.Movie;

import java.util.function.Function;
import java.util.stream.Collectors;

public class RepositoryMovieToClientMovieWithActor implements Function<Movie, MovieWithActors> {

    private final Function<Actor, ClientActor> actorToClientActor = new RepositoryActorToClientActor();
    private final Function<Movie, ClientMovie> movieToClientMovie = new RepositoryMovieToClientMovie();

    @Override
    public MovieWithActors apply(Movie movie) {
        return MovieWithActors
                .builder()
                .actors(movie
                        .getActors()
                        .stream()
                        .map(actorToClientActor)
                        .collect(Collectors.toList()))
                .movie(movieToClientMovie.apply(movie))
                .build();
    }
}
