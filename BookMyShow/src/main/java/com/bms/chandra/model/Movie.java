package com.bms.chandra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
	@Column(length=100)
	private String name;
	
	@Column(columnDefinition= " boolean default true")
	private Boolean is_active;
	
	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	@OneToMany(mappedBy="movie", fetch =FetchType.EAGER)
	private List<Screen>screen;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Screen> getScreen() {
		return screen;
	}

	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + "]";
	}
	
}
