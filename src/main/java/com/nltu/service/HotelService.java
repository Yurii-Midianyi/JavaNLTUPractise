package com.nltu.service;

import com.nltu.entity.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> getHotels();

    public List<Hotel> getAvailableHotels();

    public Hotel getHotel(int id);

    Hotel show(int id);

    void save(Hotel hotel);

    void update(Hotel updateHotel);

    void delete(int id);

    Boolean checkHotelExists(String hotelName, int countryId);
}
