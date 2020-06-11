package com.spintech.tmdb.entity.embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class EmbeddedFavoriteActor implements Serializable {
    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "user_id")
    private Long userId;
}
