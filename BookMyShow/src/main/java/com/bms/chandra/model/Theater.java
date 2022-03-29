package com.bms.chandra.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Theater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(length=100)
	private String name;
	
	@Column(length=500)
	private String address;
	
	@NotNull
	private int screen_count;
	
	@NotNull
	private String cityName;
	
	@Column(columnDefinition= " boolean default true")
	private Boolean is_active;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private City city;
	
	@OneToMany(mappedBy="theater", fetch =FetchType.LAZY)
	private List<Screen> screen;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getScreen_count() {
		return screen_count;
	}
	public void setScreen_count(int screen_count) {
		this.screen_count = screen_count;
	}
	public List<Screen> getScreen() {
		return screen;
	}
	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}
	
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", address=" + address + ", screen_count=" + screen_count
				+ ", cityName=" + cityName + ", is_active=" + is_active + "]";
	}
}
