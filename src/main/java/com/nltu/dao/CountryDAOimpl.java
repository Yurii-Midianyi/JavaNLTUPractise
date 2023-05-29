package com.nltu.dao;

import com.nltu.entity.Country;
import com.nltu.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CountryDAOimpl implements CountryDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public CountryDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void findHotelsByCountry(){
        Session session = sessionFactory.getCurrentSession();


        List<Country> countries = session.createQuery("select c from Country c where countryName = 'Poland'", Country.class).getResultList();

        for (Country country: countries) {
            System.out.println("Country " + country.getCountryName() + " has " + country.getHotels());
        }
    }
}
