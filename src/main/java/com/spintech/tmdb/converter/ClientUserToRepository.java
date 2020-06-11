package com.spintech.tmdb.converter;

import com.spintech.tmdb.dto.controller.ClientUser;
import com.spintech.tmdb.entity.User;

import java.util.function.Function;

public class ClientUserToRepository implements Function<ClientUser, User> {
    @Override
    public User apply(ClientUser clientUser) {
        return new User(clientUser.getFirstName(), clientUser.getLastName(), clientUser.getEmail());
    }
}
