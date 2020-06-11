package com.spintech.tmdb.controller;

import com.spintech.tmdb.entity.FavoriteActor;
import com.spintech.tmdb.entity.embedded.EmbeddedFavoriteActor;
import com.spintech.tmdb.repository.ActorRepository;
import com.spintech.tmdb.repository.FavoriteActorRepository;
import com.spintech.tmdb.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.spintech.tmdb.constant.Mapping.V2_ACTOR_MAPPING;


@Log4j2
@RestController
@RequestMapping(V2_ACTOR_MAPPING)
@Validated
public class ActorController {

    private final UserRepository userRepository;
    private final FavoriteActorRepository favoriteActorRepository;
    private final ActorRepository actorRepository;

    public ActorController(UserRepository userRepository, FavoriteActorRepository favoriteActorRepository, ActorRepository actorRepository) {
        this.userRepository = userRepository;
        this.favoriteActorRepository = favoriteActorRepository;
        this.actorRepository = actorRepository;
    }


    @PutMapping("/favorite/{actorId}")
    public ResponseEntity addFavorite(@PathVariable("actorId") Long actorId,
                                      @RequestParam("userId") Long userId) {

        if (checkIfExist(actorId, userId)) return ResponseEntity.notFound().build();

        favoriteActorRepository.save(FavoriteActor
                .builder()
                .embeddedFavoriteActor(EmbeddedFavoriteActor
                        .builder()
                        .actorId(actorId)
                        .userId(userId)
                        .build())
                .build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/favorite/{actorId}")
    public ResponseEntity deleteFavorite(@PathVariable("actorId") Long actorId,
                                         @RequestParam("userId") Long userId) {
        if (checkIfExist(actorId, userId)) return ResponseEntity.notFound().build();

        favoriteActorRepository.deleteById(EmbeddedFavoriteActor
                .builder()
                .userId(userId)
                .actorId(actorId)
                .build());
        return ResponseEntity.ok().build();
    }

    private boolean checkIfExist(Long actorId, Long userId) {
        if (!userRepository.existsById(userId)) {
            log.info("User with id : {} doesn't exist ", userId);
            return true;
        }

        if (!actorRepository.existsById(actorId)) {
            log.info("Actor with id : {} doesn't exist ", userId);
            return true;
        }

        return false;
    }
}
