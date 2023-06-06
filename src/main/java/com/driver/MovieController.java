package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")

public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movies")
    public ResponseEntity<String>  addMovie(@RequestBody Movie movie){
        String ans=movieService.addmovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans=movieService.addDirector(director);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("director-name") String director, @RequestParam ("movie-name") String movie){
        String ans=movieService.addDirectorMoviePair(director, movie);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name")
    public ResponseEntity<String> getMovieByName(@RequestBody Movie movie){
        String ans=movieService.getMovieByName(movie);
        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-director-by-name")
    public ResponseEntity<String> getDirectorByName(@RequestBody Director director){
        String ans=movieService.getDirectorByName(director);
        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-movies-by-director-name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestBody Director director){
        List<String>movies=new ArrayList<>();
        movies=movieService.getListofMoviebyDirectorname(director);
        return new ResponseEntity<>(movies,HttpStatus.ACCEPTED);

    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>findAllMovies(){
        List<String>movies=new ArrayList<>();
        movies=movieService.getListofMovie();
        return new ResponseEntity<>(movies,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestBody String directorName){
         String ans=movieService.removeDirector(directorName);

        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String ans=movieService.removeEverything();

        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);

    }


}

