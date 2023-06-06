package com.driver;
// service class has the base logic for the controller class and next to the base logic contain in the Repository class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addmovie(Movie movie){
        String ans=movieRepository.addmovie(movie);
        return ans;
    }
    public String addDirector(Director director){
        String ans=movieRepository.addDirector(director);
        return ans;
    }
    public String addDirectorMoviePair(String director,String movie){
        return movieRepository.addMovieDirectorPair(director, movie);
    }
    public String getMovieByName(Movie movie){
        return movieRepository.getMovieByName(movie);

    }
    public String getDirectorByName(Director director){
        return movieRepository.getDirectorByName(director);
    }

    public List<String> getListofMoviebyDirectorname(Director director){

        return movieRepository.getListofMoviebyDirectorname(director);

    }
    public List<String> getListofMovie(){
        return movieRepository.getListofMovie();

    }
    public String removeDirector(String directorName){
        return movieRepository.removeDirector(directorName);
    }

    public String removeEverything(){
        return movieRepository.removeEverything();
    }






}
