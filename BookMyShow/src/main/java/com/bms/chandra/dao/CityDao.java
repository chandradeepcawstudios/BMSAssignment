package com.bms.chandra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bms.chandra.model.City;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityDao extends JpaRepository<City, Long> {
	
	@Query("from City where city_name=:city_name")
	public City findCityByName(@Param ("city_name") String city_name);

}
