package com.spintech.tmdb.dto.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class MovieWithActors {
    private ClientMovie movie;
    private List<ClientActor> actors;
}
