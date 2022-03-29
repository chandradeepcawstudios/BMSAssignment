package com.bms.chandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.chandra.dao.TheaterDao;
import com.bms.chandra.model.Theater;
import com.bms.chandra.service.TheaterService;

@Controller
public class TheaterController {
	
	@Autowired
	TheaterDao repo;
	
	@Autowired
	TheaterService theaterService;
	
	@RequestMapping("/theater")
	@ResponseBody
	public List<Theater> getAllTheater() {
		return repo.findAll();
		
	}
	
	@PostMapping("/theater")
	@ResponseBody
	public Theater addTheater( @RequestBody Theater theater) {
		theater = theaterService.addTheater(theater);
		repo.save(theater);
		return theater;
	}
	

}
