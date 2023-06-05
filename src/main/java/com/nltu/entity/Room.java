package com.nltu.entity;


import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Min(value=1, message="must be greater than 0")
	@Max(value=10, message="must be less than or equal to 10")
	@Column(name="capacity")
	private int capacity;
	
	@Column(name="room_number")
	private int roomNumber;

	@Column(name="enabled")
	private Boolean enabled;
	
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

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", capacity=" + capacity + "]";
	}
		
}
