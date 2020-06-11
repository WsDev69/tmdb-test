package com.spintech.tmdb.converter;

import com.spintech.tmdb.dto.controller.ClientUser;
import com.spintech.tmdb.entity.User;

import java.util.function.Function;

public class RepositoryUserToClient implements Function<User, ClientUser> {
    @Override
    public ClientUser apply(User user) {
        return ClientUser
                .builder()
                .email(user.getEmail())
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
