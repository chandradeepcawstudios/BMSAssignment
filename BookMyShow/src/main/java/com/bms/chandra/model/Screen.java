package com.bms.chandra.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Screen {
	
	@Id
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int sheet_count;
	
	@Column(columnDefinition= " boolean default true")
	private Boolean is_active;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Theater theater;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Movie movie;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public int getSheet_count() {
		return sheet_count;
	}

	public void setSheet_count(int sheet_count) {
		this.sheet_count = sheet_count;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", sheet_count=" + sheet_count + ", is_active=" + is_active
				+ "]";
	}	

}
