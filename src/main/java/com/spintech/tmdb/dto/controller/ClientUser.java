package com.spintech.tmdb.dto.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientUser {

    private Long id;
    @NotNull(message = "First name should not be empty")
    private String firstName;
    @NotNull(message = "Last name should not be empty")
    private String lastName;
    @NotNull(message = "Email should not be empty")
    private String email;
}
