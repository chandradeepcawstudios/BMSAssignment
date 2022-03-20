package com.bms.chandra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.chandra.model.City;

public interface CityDao extends JpaRepository<City, Long> {

}
