package com.nltu.service;

import com.nltu.dao.CountryDAO;
import com.nltu.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    // here need autowired dao
    // in dao need do methods for search hotels in different country

    private final CountryDAO countryDAO;

    @Autowired
    public CountryServiceImpl(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    @Transactional
    public List<Country> getCountries() {
        return countryDAO.getCountries();
    }

    @Override
    @Transactional
    public Country getCountry(int id) {
        return countryDAO.getCountry(id);
    }

    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryDAO.saveCountry(country);
    }

    @Override
    @Transactional
    public void updateCountry(Country country) {
        countryDAO.updateCountry(country);
    }

    @Override
    @Transactional
    public void deleteCountry(int id) {
        countryDAO.deleteCountry(id);
    }

    @Override
    @Transactional
    public void findHotelsByCountry() {
        countryDAO.findHotelsByCountry();
    }
}