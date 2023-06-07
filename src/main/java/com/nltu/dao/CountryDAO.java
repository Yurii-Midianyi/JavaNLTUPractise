package com.nltu.dao;

import com.nltu.entity.Country;
import com.nltu.entity.Hotel;

import java.util.List;

public interface CountryDAO {
    List<Country> getCountries();

    Country getCountry(int id);

    void saveCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(int id);

    List<Hotel> findHotelsByCountry(int id);

    List<Hotel> findAvailableHotelsByCountry(int id);

}
