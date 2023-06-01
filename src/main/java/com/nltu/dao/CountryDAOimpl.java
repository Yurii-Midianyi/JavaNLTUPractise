package com.nltu.dao;

import com.nltu.entity.Country;

import com.nltu.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CountryDAOimpl implements CountryDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CountryDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Country> getCountries() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("from Country", Country.class);

        return theQuery.getResultList();
    }

    @Override
    public Country getCountry(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Country.class, id);
    }

    @Override
    public void saveCountry(Country country) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.persist(country);
    }

    @Override
    public void updateCountry(Country country) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.update(country);
    }

    @Override
    public void deleteCountry(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.remove(currentSession.get(Country.class, id));
    }

    @Override
    public List<Country> findHotelsByCountry(int id) {
        Session session = sessionFactory.getCurrentSession();

        List<Country> countries = session.createQuery("select c from Country c left join fetch c.hotels where c.id = :countryId ", Country.class )
            .setParameter("countryId", id)
            .getResultList();


        for (Country country : countries) {
            System.out.println("Country " + country.getCountryName() + " has " + country.getHotels());
        }
        return countries;
    }
}