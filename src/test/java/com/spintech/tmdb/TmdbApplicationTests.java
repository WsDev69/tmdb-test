package com.spintech.tmdb;

import com.spintech.tmdb.entity.Actor;
import com.spintech.tmdb.entity.Movie;
import com.spintech.tmdb.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@ActiveProfiles("test")
public abstract class TmdbApplicationTests {



	@MockBean
	protected UserRepository userRepository;
	@MockBean
	protected FavoriteActorRepository favoriteActorRepository;
	@MockBean
	protected MovieRepository movieRepository;
	@MockBean
	protected ActorRepository actorRepository;
	@MockBean
	protected WatchMovieRepository watchMovieRepository;



//	@Test
//	public void getFavoriteActors(){
//		var actorId = 1;
//		mvc.perform(get("/api/employees")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(1)))
//				.andExpect(jsonPath("$[0].name", is(alex.getName())))
//	}







}

