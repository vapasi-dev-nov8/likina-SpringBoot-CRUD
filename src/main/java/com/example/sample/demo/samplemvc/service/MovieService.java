package com.example.sample.demo.samplemvc.service;

import com.example.sample.demo.samplemvc.dto.Movie;
import com.example.sample.demo.samplemvc.entities.MovieEntity;
import com.example.sample.demo.samplemvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepoObj;

    @Autowired
    public MovieService(MovieRepository movieRepoObj) {
        this.movieRepoObj = movieRepoObj;
    }

    public List<Movie> serviceInvoke() {
        List<Movie> movies = new ArrayList<>();

        for (MovieEntity movieEntity : movieRepoObj.findAll()) {
            movies.add(Movie.dtoFrom(movieEntity));
        }
        return movies;

    }


    public Movie saveMovie(Movie movie) {
        MovieEntity movieEntity = MovieEntity.entityFrom(movie);
        MovieEntity savedMovieEntity = movieRepoObj.save(movieEntity);
        return Movie.dtoFrom(savedMovieEntity);
    }

    public Movie updateMovie(Movie movie) {
        MovieEntity movieEntity = MovieEntity.entityFromUpdate(movie);
        MovieEntity savedMovieEntity = movieRepoObj.save(movieEntity);
        return Movie.dtoFrom(savedMovieEntity);
    }

    public Optional<Movie> getMovie(String id) {
        Optional<MovieEntity> movieEntity = movieRepoObj.findById(id);

        return movieEntity.map(Movie::dtoFrom);
    }

    public List<Movie> getMovieByActor(List<String> actor) {

        List<Movie> movies = new ArrayList<>();

        for (MovieEntity movieEntity : movieRepoObj.findByActor(actor)) {
            movies.add(Movie.dtoFrom(movieEntity));
        }
        return movies;


    }


}
