package com.nltu.service;

import com.nltu.dao.CountryDAO;
import com.nltu.entity.Country;
import com.nltu.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final SessionFactory sessionFactory;
    private final CountryDAO countryDAO;

    @Autowired
    public CountryServiceImpl(SessionFactory sessionFactory, CountryDAO countryDAO) {
        this.sessionFactory = sessionFactory;
        this.countryDAO = countryDAO;
    }

    @Override
    @Transactional
    public List<Country> getCountries() {
        return countryDAO.getCountries();
    }

    @Override
    @Transactional
    public List<Country> getAvailableCountries() {
        return countryDAO.getAvailableCountries();
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
    public List<Hotel> findHotelsByCountry(int id) {
        return countryDAO.findHotelsByCountry(id);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
    public List<Hotel> findAvailableHotelsByCountry(int id) {
        return countryDAO.findAvailableHotelsByCountry(id);
    }

    @Override
    @Transactional
    public Boolean checkCountryExists(String countryName) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("from Country where countryName = :countryName", Country.class);
        theQuery.setParameter("countryName", countryName);

        List<Country> countries = theQuery.getResultList();

        return !countries.isEmpty();
    }
}
