package com.bms.chandra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bms.chandra.model.Screen;

public interface ScreenDao extends JpaRepository<Screen, Long> {
	
	@Query(" from Screen where theater_id=:theater_id")
	List<Screen>findScreenByTheater(@Param("theater_id") long theater_id);

}
