package com.spintech.tmdb.controller;

import com.spintech.tmdb.converter.RepositoryMovieToClientMovieWithActor;
import com.spintech.tmdb.dto.controller.MovieWithActors;
import com.spintech.tmdb.entity.Movie;
import com.spintech.tmdb.entity.WatchMovie;
import com.spintech.tmdb.entity.embedded.EmbeddedWatchMovie;
import com.spintech.tmdb.repository.MovieRepository;
import com.spintech.tmdb.repository.WatchMovieRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.function.Function;

import static com.spintech.tmdb.constant.Mapping.V1_MOVIE_MAPPING;

@Log4j2
@RestController
@RequestMapping(V1_MOVIE_MAPPING)
public class MovieController {

    private final Function<Movie, MovieWithActors> movieToClient = new RepositoryMovieToClientMovieWithActor();

    private final MovieRepository movieRepository;
    private final WatchMovieRepository watchMovieRepository;

    public MovieController(MovieRepository movieRepository, WatchMovieRepository watchMovieRepository) {
        this.movieRepository = movieRepository;
        this.watchMovieRepository = watchMovieRepository;
    }


    @GetMapping("/lists")
    public ResponseEntity<Iterable<Movie>> getTvShow(@RequestParam("page") @Min(value = 1, message = "page must be greater than or equal 1") Integer page,
                                                     @RequestParam("size") Integer size) {
        return ResponseEntity.ok(movieRepository.findAll(PageRequest.of(--page, size)));
    }

    @PutMapping("/watch/{movieId}")
    public ResponseEntity<Object> markWatch(
            @PathVariable("movieId") Long movieId,
            @RequestParam("userId") Long userId) {

        var savedObject = watchMovieRepository.save(WatchMovie
                .builder()
                .embeddedWatchMovie(EmbeddedWatchMovie
                        .builder()
                        .movieId(movieId)
                        .userId(userId)
                        .build())
                .build());

        log.trace("Movie is marked as watched {}", savedObject);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/watch/{movieId}")
    public ResponseEntity<Object> markUnWatch(
            @PathVariable("movieId") Long movieId,
            @RequestParam("userId") Long userId) {
        watchMovieRepository.deleteById(EmbeddedWatchMovie
                .builder()
                .userId(userId)
                .movieId(movieId)
                .build());
        return ResponseEntity.ok().build();
    }


    @GetMapping("/unwatch/lists")
    public ResponseEntity<Page<MovieWithActors>> getUnwatchedWithFavoriteActors(@RequestParam("userId") Long userId,
                                                                                @RequestParam("page") @Min(value = 1, message = "page must be greater than or equal 1") Integer page,
                                                                                @RequestParam("size") Integer size) {
        var result = movieRepository.findByUserIdAndFavoriteActors(userId, PageRequest.of(--page, size));
        return ResponseEntity.ok(result.map(movieToClient));
    }

}
