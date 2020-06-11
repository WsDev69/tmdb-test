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
public class EmbeddedWatchMovie implements Serializable {
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "user_id")
    private Long userId;
}
