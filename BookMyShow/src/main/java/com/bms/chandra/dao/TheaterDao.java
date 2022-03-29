package com.bms.chandra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bms.chandra.model.Theater;

public interface TheaterDao extends JpaRepository<Theater, Long> {
	
	@Query(" from Theater where city_id=:city_id")
	List<Theater> findTheaterByCity(@Param ("city_id") long city_id);

}
