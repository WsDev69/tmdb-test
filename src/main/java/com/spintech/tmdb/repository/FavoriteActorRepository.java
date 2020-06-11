package com.spintech.tmdb.repository;

import com.spintech.tmdb.entity.embedded.EmbeddedFavoriteActor;
import com.spintech.tmdb.entity.FavoriteActor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface FavoriteActorRepository extends CrudRepository<FavoriteActor, EmbeddedFavoriteActor> {
}
