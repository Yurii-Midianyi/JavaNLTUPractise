package com.nltu.DTO;

public class HotelDTO {
	private int id;
	private String hotelName;

    public HotelDTO(int id, String hotelName) {
        this.id = id;
        this.hotelName = hotelName;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}	
}
