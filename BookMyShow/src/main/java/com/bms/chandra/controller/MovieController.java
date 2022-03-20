package com.bms.chandra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.chandra.dao.MovieDao;
import com.bms.chandra.model.Movie;

@Controller
public class MovieController {
	
	@Autowired
	MovieDao repo;
	
	@PostMapping("/movie")
	@ResponseBody
	public Movie addMovie(@RequestBody Movie movie) {
		repo.save(movie);
		return movie;
	}
	
	@RequestMapping("/movie")
	@ResponseBody
	public List<Movie> getAllMovie() {
		return repo.findAll();
	}
	
	@RequestMapping("/movie/{id}")
	@ResponseBody
	public Optional<Movie> getById(@PathVariable long id){
		return repo.findById(id);
	}

}
