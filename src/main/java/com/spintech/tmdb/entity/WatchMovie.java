package com.spintech.tmdb.entity;


import com.spintech.tmdb.entity.embedded.EmbeddedFavoriteActor;
import com.spintech.tmdb.entity.embedded.EmbeddedWatchMovie;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Table(name = "watch_movie")
public class WatchMovie  {
    @EmbeddedId
    private EmbeddedWatchMovie embeddedWatchMovie;
}
