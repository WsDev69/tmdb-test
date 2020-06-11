package com.spintech.tmdb.controller;

import com.spintech.tmdb.TmdbApplicationTests;
import com.spintech.tmdb.entity.FavoriteActor;
import com.spintech.tmdb.entity.embedded.EmbeddedFavoriteActor;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ActorController.class)
class ActorControllerTest extends TmdbApplicationTests {

    @Autowired
    private MockMvc mvc;

    @SneakyThrows
    @Test
    public void addFavoritePositive() {
        var userId = 1L;
        var actorId = 1L;
        var favoriteActor = getFavoriteActor(userId, actorId);
        Mockito.when(userRepository.existsById(userId))
                .thenReturn(true);
        Mockito.when(actorRepository.existsById(actorId))
                .thenReturn(true);
        Mockito.when(favoriteActorRepository.save(favoriteActor))
                .thenReturn(favoriteActor);

        mvc.perform(delete(String.format("/api/v1/actor/favorite/%s?userId=%s", actorId, userId)))
                .andExpect(status().isOk());
    }



    @SneakyThrows
    @Test
    public void removeFavoritePositive() {
        var userId = 1L;
        var actorId = 1L;
        var favoriteActor = getFavoriteActor(userId, actorId);
        Mockito.when(userRepository.existsById(userId))
                .thenReturn(true);
        Mockito.when(actorRepository.existsById(actorId))
                .thenReturn(true);
        Mockito.when(favoriteActorRepository.save(favoriteActor))
                .thenReturn(favoriteActor);

        mvc.perform(delete(String.format("/api/v1/actor/favorite/%s?userId=%s", actorId, userId)))
                .andExpect(status().isOk());
    }

    private FavoriteActor getFavoriteActor(Long userId, Long actorId) {
        return FavoriteActor
                .builder()
                .embeddedFavoriteActor(EmbeddedFavoriteActor
                        .builder()
                        .actorId(actorId)
                        .userId(userId)
                        .build())
                .build();
    }


}