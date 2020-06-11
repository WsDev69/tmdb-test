package com.spintech.tmdb.repository;

import com.spintech.tmdb.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface UserRepository extends CrudRepository<User, Long> {

}
