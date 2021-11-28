package com.example.sample.demo.samplemvc.entities;

import com.example.sample.demo.samplemvc.dto.Movie;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String movie;
    String actor;
    String director;

    public MovieEntity() {
    }

    public MovieEntity(String id, String movie, String actor, String director) {
        this.id = id;
        this.movie = movie;
        this.actor = actor;
        this.director = director;
    }

    public static MovieEntity entityFrom(Movie movie) {
        return new MovieEntity(null, movie.getMovie(), movie.getActor(), movie.getDirector());
    }

    public static MovieEntity entityFromUpdate(Movie movie) {
        return new MovieEntity(movie.getId(), movie.getMovie(), movie.getActor(), movie.getDirector());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}