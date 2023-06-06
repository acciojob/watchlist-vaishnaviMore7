package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String,Movie> moviedb=new HashMap<>();
    HashMap<String,Director>directordb=new HashMap<>();
    HashMap<String,String>Pairdb=new HashMap<>();
     public String addmovie(Movie movie){
        String key=movie.getName();
        moviedb.put(key,movie);
        return "Successfully added movie ";
     }
     public String addDirector(Director director){
         String key=director.getName();
         directordb.put(key,director);
         return "Director name added successfully in database";
     }
     public String addMovieDirectorPair(String director,String movie){
         Pairdb.put(director, movie);
         return "Pair duo added successfully";
     }
     public String getMovieByName(Movie movie){
         String key=movie.getName();
         directordb.get(key);
         return "Search the movie by name successfully";
     }
    public String getDirectorByName(Director director){
        String key=director.getName();
        directordb.get(key);
        return "Search the director by name successfully";
    }

    public List<String> getListofMoviebyDirectorname(Director director){
         List<String>movies=new ArrayList<>();
         for(Map.Entry<String,String>entry:Pairdb.entrySet()){
             if(entry.getValue().equals(director)){
                 String moviename= entry.getKey();
                 movies.add(moviename);
             }
         }
         return movies;

    }
    public List<String> getListofMovie(){
        List<String>movies=new ArrayList<>();
        for(Map.Entry<String,String>entry:Pairdb.entrySet()){
            String moviename= entry.getKey();
            movies.add(moviename);
        }
        return movies;

    }
    public String removeDirector(String directorName){

            directordb.remove(directorName);
            for(Map.Entry<String,String> entryset: Pairdb.entrySet()){
                if(entryset.getValue().equals(directorName)){
                    String moviename= entryset.getKey();
                    moviedb.remove(moviename);
                    Pairdb.remove(moviename);
                }
            }

        return "remove everything successfully";
    }

     public String removeEverything(){
         for(String directorName : directordb.keySet()){
             directordb.remove(directorName);
             for(Map.Entry<String,String> entryset: Pairdb.entrySet()){
                 if(entryset.getValue().equals(directorName)){
                     String moviename= entryset.getKey();
                     moviedb.remove(moviename);
                     Pairdb.remove(moviename);
                 }
             }
         }
         return "remove everything successfully";
     }


}
