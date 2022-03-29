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
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(unique=true, length=100)
	private String city_name;
	
	@NotNull
	private String state_name;
	
	@NotNull
	private String country_name;
	
	@Column(columnDefinition= " boolean default true")
	private Boolean is_active;
	
	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	@OneToMany(mappedBy="city", fetch =FetchType.LAZY)
	private List<Theater> theater;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public List<Theater> getTheater() {
		return theater;
	}

	public void setTheater(List<Theater> theater) {
		this.theater = theater;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city_name=" + city_name + ", state_name=" + state_name + ", country_name="
				+ country_name + ", is_active=" + is_active + "]";
	}

}
