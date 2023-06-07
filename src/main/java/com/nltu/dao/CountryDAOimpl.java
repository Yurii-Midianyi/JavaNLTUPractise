package com.nltu.dao;

import com.nltu.entity.Country;

import com.nltu.entity.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

//        currentSession.remove(currentSession.get(Country.class, id));

        Query<?> theQuery = currentSession.createQuery("update Country set enabled = false where id = :id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();
    }

    @Override
    public List<Hotel> findHotelsByCountry(int id) {
        Session session = sessionFactory.getCurrentSession();

        List<Hotel> hotels = session.createQuery("select h from Country c join c.hotels h where c.id = :countryId", Hotel.class)
                .setParameter("countryId", id)
                .getResultList();

        return hotels;
    }

    @Override
    public List<Hotel> findAvailableHotelsByCountry(int id) {
        Session session = sessionFactory.getCurrentSession();

        List<Hotel> hotels = session.createQuery("select h from Country c join c.hotels h where c.id = :countryId and c.enabled = true ", Hotel.class)
                .setParameter("countryId", id)
                .getResultList();

        return hotels;
    }

    @Override
    public Boolean checkCountryExists(String countryName) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("from Country where countryName = :countryName", Country.class);
        theQuery.setParameter("countryName", countryName);

        List<Country> countries = theQuery.getResultList();

        return !countries.isEmpty();
    }
}


