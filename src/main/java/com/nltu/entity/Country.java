package com.nltu.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="country_name")
	private String countryName;
	
	@OneToMany(mappedBy = "country")
    private List<Hotel> hotels;

	public Country() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return countryName;
	}
		
}
