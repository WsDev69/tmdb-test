package com.spintech.tmdb.repository;

import com.spintech.tmdb.entity.Actor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;


@Profile("!test")
public interface ActorRepository extends CrudRepository<Actor, Long> {




}
