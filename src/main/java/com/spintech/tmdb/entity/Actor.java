package com.spintech.tmdb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;

    private String firstName;
    private String lastName;
}




