package com.spintech.tmdb.controller;

import com.spintech.tmdb.converter.ClientUserToRepository;
import com.spintech.tmdb.converter.RepositoryUserToClient;
import com.spintech.tmdb.dto.controller.ClientUser;
import com.spintech.tmdb.entity.User;
import com.spintech.tmdb.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

import static com.spintech.tmdb.constant.Mapping.V3_USER_MAPPING;


@Log4j2
@RestController
@RequestMapping(V3_USER_MAPPING)
@Validated
public class UserController {


    private final Function<User, ClientUser> userToClient = new RepositoryUserToClient();
    private final Function<ClientUser, User> clientUserToRepository = new ClientUserToRepository();

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PutMapping("/add")
    public ResponseEntity<ClientUser> addUser(@RequestBody ClientUser clientUser) {
        return ResponseEntity
                .ok(userToClient.apply(
                        userRepository.save(
                                clientUserToRepository.apply(clientUser))));
    }
}
