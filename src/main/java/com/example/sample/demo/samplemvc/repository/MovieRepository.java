package com.example.sample.demo.samplemvc.repository;

import com.example.sample.demo.samplemvc.entities.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, String> {

    @Query("from MovieEntity m where m.actor in (:actor)")
        // @Query("from MovieEntity m where m.actor=:actor")
    List<MovieEntity> findByActor(@Param("actor") List<String> actor);


}


// List<User> findUsersByAge(int age);

    /*List<Movie> movieList = new ArrayList(Arrays.asList(new Movie(100, "Hindi", "ShahRukh", "KaranJohar"),
       new Movie(101,"Tamil", "Vijay", "Shankar"),
        new Movie(102,"Malayalam", "Mohanlal", "Priyadarshan")));
    public List<Movie> repositoryInvoke() {

        return movieList;
    }

    public Movie saveMovie(Movie movie) {
        int newId = movieList.get(movieList.size() - 1).getId() + 1;
        Movie movieToBeSaved = new Movie(newId, movie.getMovie(), movie.getActor(), movie.getDirector());
        movieList.add(movieToBeSaved);
        return movieToBeSaved;
    }*/



