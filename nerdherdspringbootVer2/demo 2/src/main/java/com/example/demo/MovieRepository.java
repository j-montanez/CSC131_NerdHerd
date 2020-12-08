package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

	
//    int count();
//
//    int save(Movie movie);
//
//    int update(Movie movie);
//
//    int deleteById(Long id);
//    
//    int increaseVoteCount(int id);
//
//    List<Movie> findAll();
//
//    List<Movie> findByNameAndYear(String name, String year);
//
//    Optional<Movie> findById(Long id);
//
//    String getNameById(Long id);
	List<Movie> findByOscar(String name);

	List<Movie> findAllByYear(String year);

	List<Movie> findByName(String name);
	
	List<MovieAwards> findAwards(String name);

    
}
