package com.spintech.tmdb.controller;

import com.spintech.tmdb.TmdbApplicationTests;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
class MovieControllerTest extends TmdbApplicationTests {
    @Autowired
    private MockMvc mvc;


}