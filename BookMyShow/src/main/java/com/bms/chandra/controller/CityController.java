package com.bms.chandra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.chandra.dao.CityDao;
import com.bms.chandra.model.City;

@RestController
public class CityController {
	
	@Autowired
	CityDao repo;
	
	@PostMapping("/city")
	public City addCity(@RequestBody City city) {
		repo.save(city);
		return city;
	}
	
	@GetMapping("/city")
	public List<City> getCity() {
		return repo.findAll();
	}
	
	@GetMapping("/city/{id}")
	public Optional<City> getCityById(@PathVariable long id) {
		return repo.findById(id);
	}

}
