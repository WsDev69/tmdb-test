package com.spintech.tmdb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
public class Movie {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "movie_id",unique = true)
    private Long movieId;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;


    @ManyToMany
    @JoinTable(
            name="movie_actor",
            joinColumns = @JoinColumn( name="movie_id"),
            inverseJoinColumns = @JoinColumn( name="actor_id")
    )
    private Set<Actor> actors = new HashSet<>();
}
