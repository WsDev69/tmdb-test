package com.spintech.tmdb.dto.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientMovie {
    @NotNull(message = "Movie name should not be empty")
    private String name;
    @NotNull(message = "Movie description should not be empty")
    private String description;
}
