package com.nltu.entity;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="capacity")
	private int capacity;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	@OneToMany(mappedBy="room", cascade=CascadeType.ALL)
	private List<Booking> bookings;
	
	public Room() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", capacity=" + capacity + "]";
	}
		
}
