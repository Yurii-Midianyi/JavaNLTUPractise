package com.nltu.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Username can't be empty")
	@Column(name="username", unique = true)
	private String username;

	@NotEmpty(message = "Password can't be empty")
	@Column(name="password")
	private String password;

	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade =
					{CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Booking> bookings;
	
	public User(){}

	public User(String username, String password, boolean enabled, Role role, List<Booking> bookings) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.bookings = bookings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + "]";
	}
	
}
