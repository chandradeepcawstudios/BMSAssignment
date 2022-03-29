package com.bms.chandra.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.chandra.model.City;
import com.bms.chandra.model.Movie;
import com.bms.chandra.model.Screen;
import com.bms.chandra.model.Theater;
import com.bms.chandra.service.CityService;
import com.bms.chandra.service.ScreenService;
import com.bms.chandra.service.TheaterService;

@Controller
public class PlayerController {

	@Autowired
	CityService cityService;
	
	@Autowired
	TheaterService theaterService;
	
	@Autowired
	ScreenService screenService;
	
	@RequestMapping("/player/movie/{city_name}")
	@ResponseBody
	public List<Movie> movieList(@PathVariable String city_name){
		List<Movie>movies = new ArrayList<>();
		City city = cityService.getCityByName(city_name);
		long id = city.getId();
		List<Theater> theaters = theaterService.getTheaterByCity(id);
		for(Theater theater : theaters) {
			long theater_id = theater.getId();
			List<Screen> screens = screenService.getScreenByTheater(theater_id);
			for(Screen screen: screens) {
				Movie movie = screen.getMovie();
				movies.add(movie);
			}
		}
		return movies;
	}
}
