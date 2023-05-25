package com.nltu.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="hotel_name")
	private String name;
	
	@Column(name="country_id")
	private String country;
	
	@OneToMany(mappedBy ="hotel",
			   cascade = {CascadeType.PERSIST, CascadeType.MERGE,
						  CascadeType.DETACH, CascadeType.REFRESH})
	private List<Room> rooms;
	
	public Hotel() {}

	public Hotel(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	public void add(Room tempRoom) {
		if(rooms == null) {
			rooms = new ArrayList<>();
		}
		rooms.add(tempRoom);
		tempRoom.setHotel(this);
	}
}
