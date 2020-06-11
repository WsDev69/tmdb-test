package com.spintech.tmdb.config;

import com.spintech.tmdb.repository.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class MockBeanConfig {

    @Primary
    @Bean
    public ActorRepository mockActorRepository(){
        return Mockito.mock(ActorRepository.class);
    }
    @Primary
    @Bean
    public FavoriteActorRepository mockFavoriteActorRepository(){
        return Mockito.mock(FavoriteActorRepository.class);
    }
    @Primary
    @Bean
    public MovieRepository mockMovieRepository(){
        return Mockito.mock(MovieRepository.class);
    }
    @Primary
    @Bean
    public UserRepository mockUserRepository(){
        return Mockito.mock(UserRepository.class);
    }
    @Primary
    @Bean
    public WatchMovieRepository mockWatchMovieRepository(){
        return Mockito.mock(WatchMovieRepository.class);
    }
}
