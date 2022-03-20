package com.bms.chandra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.chandra.dao.CityDao;
import com.bms.chandra.model.City;

@Controller
public class CityController {
	
	@Autowired
	CityDao repo;
	
	@PostMapping("/city")
	@ResponseBody
	public City addCity(@RequestBody City city) {
		repo.save(city);
		return city;
	}
	
	@GetMapping("/city")
	@ResponseBody
	public List<City> getCity() {
		return repo.findAll();
	}
	
	@GetMapping("/city/{id}")
	@ResponseBody
	public Optional<City> getCityById(@PathVariable long id) {
		return repo.findById(id);
	}

}
