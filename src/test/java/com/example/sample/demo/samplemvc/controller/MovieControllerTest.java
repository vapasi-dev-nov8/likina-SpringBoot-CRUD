package com.example.sample.demo.samplemvc.controller;

import com.example.sample.demo.samplemvc.dto.Movie;
import com.example.sample.demo.samplemvc.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;


    @Test
    void shouldExpectOKForMoviesReturned() throws Exception {
        mockMvc.perform(get("/api/v1/movie/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(movieService, times(1)).serviceInvoke();
    }

    @Test
    void shouldExpectNotFoundErrorWhenUrlIsWrog() throws Exception {
        mockMvc.perform(get("/api/v1/movie")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
        verify(movieService, times(0)).serviceInvoke();
    }

/*@Test
    void shouldExpectCreatedIfMovieIsSavedCorrectly() throws Exception {
        Movie movie = new Movie(null,"Movie Name", "Actor Name", "Director Name");
    Movie savedMovie = new Movie("1", "Movie Name", "Actor Name", "Director Name");
   when(movieService.saveMovie(movie)).thenReturn(savedMovie);
   mockMvc.perform(post("/api/v1/movie/").content(asJsonString(movie)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.content().json(asJsonString(savedMovie)));
   verify(movieService, times(1)).saveMovie(movie);

    }

    private String asJsonString(Movie movie) {
        try {
            return new ObjectMapper().writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
