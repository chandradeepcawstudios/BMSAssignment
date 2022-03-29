package com.bms.chandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.chandra.dao.CityDao;
import com.bms.chandra.model.City;

@Service
public class CityService {

	@Autowired
	CityDao cityRepo;
	public City getCityByName(String city_name) {
		City city = cityRepo.findCityByName(city_name);
		return city;
	}
}
