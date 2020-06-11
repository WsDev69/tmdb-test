package com.spintech.tmdb.converter;

import com.spintech.tmdb.dto.controller.ClientActor;
import com.spintech.tmdb.entity.Actor;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

public class RepositoryActorToClientActor implements Function<Actor, ClientActor> {

    @Override
    public ClientActor apply(Actor actor) {
        return ClientActor
                .builder()
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .build();
    }
}
