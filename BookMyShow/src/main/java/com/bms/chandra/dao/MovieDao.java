package com.bms.chandra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.chandra.model.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {

}
