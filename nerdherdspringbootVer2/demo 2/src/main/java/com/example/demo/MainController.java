package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private JDBCMovieRepository movieRepository;
  private ParticipantRepository participantRepository ;

//  @PostMapping(path="/add") // Map ONLY POST Requests
//  public @ResponseBody String addNewMovie (@RequestParam String name, @RequestParam int year) {
//    // @ResponseBody means the returned String is the response, not a view name
//    // @RequestParam means it is a parameter from the GET or POST request
//
//    Movie n = new Movie(10000, name, year);
//    movieRepository.save(n);
//    return "Saved";
//  }



//  @GetMapping(path="/all")
//  public @ResponseBody Iterable<Movie> getAllMovies() {
//    // This returns a JSON or XML with the users
//    return movieRepository.findAll();
//  }
//  
//  @GetMapping(path="/find")
//  public @ResponseBody Iterable<Movie> find(@RequestParam String name, @RequestParam int year) {
//    return movieRepository.findByNameAndYear(name, year);
//  }
//  
// 
  @GetMapping(path="/findAllByYear")
  public @ResponseBody List<Movie> findAllByYear(@RequestParam String year) {
    return movieRepository.findAllByYear(year);
  }
  @GetMapping(path="/findByName")
  public @ResponseBody List<Movie> findByName(@RequestParam String name) {
    return movieRepository.findByName(name);
  }
  @GetMapping(path="/findAwards")
  public @ResponseBody List<MovieAwards> findAwards(@RequestParam String name) {
    return movieRepository.findAwards(name);
  }
  
}
