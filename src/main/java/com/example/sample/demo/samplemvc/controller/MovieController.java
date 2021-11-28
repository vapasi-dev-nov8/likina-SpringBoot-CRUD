package com.example.sample.demo.samplemvc.controller;

import com.example.sample.demo.samplemvc.dto.Movie;
import com.example.sample.demo.samplemvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    MovieService movieServiceObj;


    @Autowired
    public MovieController(MovieService movieServiceObj) {
        this.movieServiceObj = movieServiceObj;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovie() {
        List<Movie> movies = movieServiceObj.serviceInvoke();
        return ResponseEntity.ok().body(movies);
    }

    /*@PostMapping("/")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Movie movieWithId = movieServiceObj.saveMovie(movie);
        return new ResponseEntity<Movie>(movieWithId, HttpStatus.CREATED);

    }*/

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie movieWithId = movieServiceObj.saveMovie(movie);
        return new ResponseEntity<>(movieWithId, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")

    public ResponseEntity<Movie> getMovieForId(@PathVariable String id) {
        Optional<Movie> movie = movieServiceObj.getMovie(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        }
        return ResponseEntity.notFound().build();

    }

    // ability to update an existing movie record.
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable String id) {
        Optional<Movie> updateMovie = movieServiceObj.getMovie(id);
        if (updateMovie.isPresent()) {

            Movie movieToBeUpdated = updateMovie.get();

            movieToBeUpdated.setId(movie.getId());
            movieToBeUpdated.setMovie(movie.getMovie());

            movieToBeUpdated.setActor(movie.getActor());
            movieToBeUpdated.setDirector(movie.getDirector());


            Movie movieWithId = movieServiceObj.updateMovie(movieToBeUpdated);
            return ResponseEntity.ok().body(movieWithId);
            // return ResponseEntity.ok(movieWithId);
        }
        return ResponseEntity.notFound().build();
    }

    // ability to filter movies on the basis of a list of actors
    //endpoint?actor=xx,yy
    @GetMapping("/filter")
    public ResponseEntity<List<Movie>> filterMovieByListOfActors(@RequestParam List<String> actor) {

        List<Movie> movie = movieServiceObj.getMovieByActor(actor);
        return ResponseEntity.ok().body(movie);

    }
}