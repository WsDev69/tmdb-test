package com.spintech.tmdb.repository;

import com.spintech.tmdb.entity.WatchMovie;
import com.spintech.tmdb.entity.embedded.EmbeddedWatchMovie;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface WatchMovieRepository extends CrudRepository<WatchMovie, EmbeddedWatchMovie> {
}
