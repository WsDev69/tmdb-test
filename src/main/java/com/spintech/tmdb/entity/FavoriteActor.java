package com.spintech.tmdb.entity;


import com.spintech.tmdb.entity.embedded.EmbeddedFavoriteActor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Entity
@Data
@Table(name = "favorite_actor")
public class FavoriteActor {
    @EmbeddedId
    private EmbeddedFavoriteActor embeddedFavoriteActor;
}
