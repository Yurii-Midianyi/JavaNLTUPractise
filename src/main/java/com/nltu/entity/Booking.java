package com.nltu.entity;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@FutureOrPresent(message="not valid date")
	@Column(name="booked_since")
	private LocalDate bookedSince;
	
	@FutureOrPresent(message="not valid date")
	@Column(name="booked_to")
	private LocalDate bookedTo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="room_id")
	private Room room;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	@Column(name="enabled")
	private Boolean enabled;
	
	public Booking() {}
	
	public Booking(LocalDate bookedSince, LocalDate bookedTo, Room room, User user, boolean enabled) {		
		this.bookedSince = bookedSince;
		this.bookedTo = bookedTo;
		this.room = room;
		this.user = user;
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getBookedSince() {
		return bookedSince;
	}

	public void setBookedSince(LocalDate bookedSince) {
		this.bookedSince = bookedSince;
	}

	public LocalDate getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookedSince=" + bookedSince + ", bookedTo=" + bookedTo + ", room=" + room
				+ ", user=" + user + "]";
	}
	
}
