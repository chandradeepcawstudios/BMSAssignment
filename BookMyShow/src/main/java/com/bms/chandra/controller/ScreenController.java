package com.bms.chandra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.bms.chandra.dao.MovieDao;
import com.bms.chandra.dao.ScreenDao;
import com.bms.chandra.dao.TheaterDao;
import com.bms.chandra.model.Movie;
import com.bms.chandra.model.Screen;
import com.bms.chandra.model.Theater;
import com.bms.chandra.service.ScreenService;

@Controller
public class ScreenController {
	
	@Autowired
	ScreenDao repo;
	@Autowired
	TheaterDao theaterRepo;
	@Autowired
	MovieDao movieRepo;
	
	@Autowired
	ScreenService screenService;
	
	@RequestMapping("/screen")
	@ResponseBody
	public List<Screen> getScreen() {
		return repo.findAll();
	}
	
	@PostMapping("/screen/{theater_id}")
	@ResponseBody
	public Screen addScreen(@RequestBody Screen screen, @PathVariable long theater_id) {
		screen = screenService.addScreenService(screen,theater_id);
		return screen;
	}
	
	@RequestMapping("/screen/{id}/{movie_id}")
	@ResponseBody
	public Screen AddMovieToScreen(@PathVariable long id,@PathVariable Long movie_id) throws Exception {
		Screen screen = screenService.addMovieToScreenService(id, movie_id);
		return screen;
		
	}
}