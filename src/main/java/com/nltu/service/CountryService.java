package com.nltu.service;

import com.nltu.entity.Country;
import com.nltu.entity.Hotel;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    List<Country> getAvailableCountries();

    Country getCountry(int id);

    void saveCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(int id);

    List<Hotel> findHotelsByCountry(int id);

    List<Hotel> findAvailableHotelsByCountry(int id);

    Boolean checkCountryExists(String countryName);

}
