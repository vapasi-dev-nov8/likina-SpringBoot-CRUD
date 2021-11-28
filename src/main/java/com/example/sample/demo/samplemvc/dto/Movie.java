package com.example.sample.demo.samplemvc.dto;

import com.example.sample.demo.samplemvc.entities.MovieEntity;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class Movie {
    String id;
    String movie;
    String actor;
    String director;

    @JsonCreator
    public Movie(String movie, String actor, String director) {
        this.id = null;
        this.movie = movie;
        this.actor = actor;
        this.director = director;
    }

    public Movie(String id, String movie, String actor, String director) {
        this.id = id;
        this.movie = movie;
        this.actor = actor;
        this.director = director;
    }

    public static Movie dtoFrom(MovieEntity movieEntity) {
        return new Movie(movieEntity.getId(), movieEntity.getMovie(), movieEntity.getActor(), movieEntity.getDirector());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie1 = (Movie) o;
        return id == movie1.id && movie.equals(movie1.movie) && actor.equals(movie1.actor) && director.equals(movie1.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, actor, director);
    }
}
