package com.bms.chandra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.chandra.dao.MovieDao;
import com.bms.chandra.dao.ScreenDao;
import com.bms.chandra.dao.TheaterDao;
import com.bms.chandra.model.Movie;
import com.bms.chandra.model.Screen;
import com.bms.chandra.model.Theater;

@Service
public class ScreenService {
	
	@Autowired
	TheaterDao theaterRepo;
	
	@Autowired
	ScreenDao screenRepo;
	
	@Autowired
	MovieDao movieRepo;
	
	public Screen addScreenService(Screen screen, long id) {
		Optional<Theater> theaterObj = theaterRepo.findById(id);
		if(theaterObj.isPresent()) {
			Theater theater = theaterObj.get();
			screen.setTheater(theater);
			screenRepo.save(screen);
		}
		else {
			System.out.println("Thaeter not present");
		}
		return screen;
	}
	
	public Screen addMovieToScreenService(long screen_id, long movie_id) {
		Optional<Screen> screenObj = screenRepo.findById(screen_id);
		Screen screen = null;
		if(screenObj.isPresent()) {
			screen = screenObj.get();
		}
		else{
			System.out.println("Screen id not correct");
		}
		 Optional<Movie> movieObj= movieRepo.findById(movie_id);
		 if(movieObj.isPresent()){
			 Movie movie = movieObj.get();
			 screen.setMovie(movie);
			 screenRepo.save(screen);
		 }
		 else {
			 System.out.println("MOvie not present");
		 }
		 
		return screen;
	}

	public List<Screen> getScreenByTheater(long theater_id) {
		List<Screen>screens = screenRepo.findScreenByTheater(theater_id);
				return screens;
	}
	
}
