package com.nltu.service;

import com.nltu.entity.Country;
import com.nltu.entity.Hotel;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    Country getCountry(int id);

    void saveCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(int id);

    List<Country> findHotelsByCountry(int id);

}
