package com.bms.chandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.chandra.dao.CityDao;
import com.bms.chandra.dao.TheaterDao;
import com.bms.chandra.model.City;
import com.bms.chandra.model.Theater;

@Service
public class TheaterService {
	
	@Autowired
	CityDao cityRepo;
	
	@Autowired
	TheaterDao theaterRepo;
	
	public Theater addTheater(Theater theater) {
		
		String cityName = theater.getCityName();
		City city = cityRepo.findCityByName(cityName);
		theater.setCity(city);
		return theater;
	}
	
	public List<Theater> getTheaterByCity(long city_id){
		List<Theater> theaters = theaterRepo.findTheaterByCity(city_id);
		return theaters;
	}

}
