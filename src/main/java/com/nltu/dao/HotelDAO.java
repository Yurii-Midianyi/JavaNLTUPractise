package com.nltu.dao;

import java.util.List;
import com.nltu.entity.Hotel;

public interface HotelDAO {
	public List<Hotel> getHotels();
	
	public Hotel getHotel(int id);
}
