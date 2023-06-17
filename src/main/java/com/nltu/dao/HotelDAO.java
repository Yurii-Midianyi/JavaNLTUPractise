package com.nltu.dao;

import java.util.List;
import com.nltu.entity.Hotel;

public interface HotelDAO {
	public List<Hotel> getHotels();

	public List<Hotel> getAvailableHotels();

	public Hotel getHotel(int id);

	Hotel show(int id);

	void save(Hotel hotel);

	void update(int id, Hotel updateHotel);

	void delete(int id);

}
