package com.example.sample.demo.samplemvc.service;

import com.example.sample.demo.samplemvc.repository.MovieRepository;
import com.example.sample.demo.samplemvc.dto.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes=MovieService.class)
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @InjectMocks
    MovieService movieService;

    @MockBean
    MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        this.movieService.movieRepoObj = this.movieRepository;
        //or
        //movieRepository = mock(MovieRepository.class);
        //movieService = new MovieService(movieRepository);
    }

    /*@Test
    public void getAllMoviesAddedToList() {
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie(100,"Hindi", "ShahRukh", "KaranJohar"));
        allMovies.add(new Movie(101,"Tamil", "Vijay", "Shankar"));
        allMovies.add(new Movie(102,"Malayalam", "Mohanlal", "Priyadarshan"));
        when(movieRepository.repositoryInvoke()).thenReturn(allMovies);
        List<Movie> totalMovies = movieService.serviceInvoke();
        verify(movieRepository, times(1)).repositoryInvoke();
        assertEquals(allMovies, totalMovies);
    }

    @Test
    public void getEmptyMoviesWhenNoMoviesAddedToList() {
        List<Movie> allMovies = new ArrayList<>();

        when(movieRepository.repositoryInvoke()).thenReturn(allMovies);
        List<Movie> totalMovies = movieService.serviceInvoke();
        verify(movieRepository, times(1)).repositoryInvoke();
        assertEquals(allMovies.size(), 0);
//assertEquals(allMovies.size(), totalMovies.size());

    }
    @Test
    public void shouldSaveMovieAndReturnSavedMovieDetails(){
        Movie movie = mock(Movie.class);
        Movie savedMovie = mock(Movie.class);
        when(movieRepository.saveMovie(movie)).thenReturn(savedMovie);
        Movie actualMovie = movieService.saveMovie(movie);
        assertEquals(savedMovie, actualMovie);*/

    }
