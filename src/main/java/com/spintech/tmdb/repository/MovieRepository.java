package com.spintech.tmdb.repository;

import com.spintech.tmdb.entity.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Locale;
import java.util.Set;

@Profile("!test")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
    @Query(nativeQuery = true, value = "SELECT m FROM movie m JOIN (SELECT ma.movie_id FROM movie_actor ma where ma.actor_id IN (#{ids})) as ma on m.movie_id = ma.movie_id")
    List<Movie> findByActors(@Param("ids") List<String> ids);

    /*
    select distinct m.* from movie as m
join movie_actor as ma on m.movie_id = ma.movie_id
join watch_movie as wm on m.movie_id <> wm.movie_id
where actor_id in (select fa.actor_id from favorite_actor as fa
where user_id = 1)
     */

    @Query(nativeQuery = true, value = "SELECT distinct m.* FROM FAVORITE_ACTOR fa " +
            "            join movie_actor ma on fa.actor_id = ma.actor_id " +
            "            join movie m on ma.movie_id = m.movie_id " +
            "            where m.movie_id not in (select wm.movie_id from watch_movie wm where wm.user_id = ?1)"
    )
    Page<Movie> findByUserIdAndFavoriteActors(@Param("userId") Long userId, Pageable pageable);

}
