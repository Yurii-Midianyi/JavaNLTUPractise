package com.nltu.dao;

import com.nltu.entity.Booking;
import com.nltu.entity.Country;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Country> getAvailableCountries() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery =
                currentSession.createQuery("from Country where enabled = true", Country.class);

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

        currentSession.merge(country);
    }

    @Override
    public void deleteCountry(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Country country = currentSession.get(Country.class, id);

        if (!bookingsExist(country)) {
            currentSession.remove(country);
        }
        else {
            disableCountry(currentSession, country);
            disableHotels(currentSession, country);
            disableRooms(currentSession, country.getHotels());
            disableBookings(currentSession, country.getHotels());
        }
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

        List<Hotel> hotels = session.createQuery("select h from Country c join c.hotels h where c.id = :countryId and c.enabled = true and h.enabled = true", Hotel.class)
                .setParameter("countryId", id)
                .getResultList();

        return hotels;
    }

    private Boolean bookingsExist(Country country) {
        for (Hotel hotel: country.getHotels()) {
            for (Room room: hotel.getRooms()) {
                if (!room.getBookings().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void disableCountry(Session session, Country country) {
        Query<?> theQuery =
                session.createQuery("update Country set enabled = false where id = :id");
        theQuery.setParameter("id", country.getId());
        theQuery.executeUpdate();
    }

    private void disableHotels(Session session, Country country) {
        Query<?> theQuery =
                session.createQuery("update Hotel set enabled = false where country = :country");
        theQuery.setParameter("country", country);
        theQuery.executeUpdate();
    }

    private void disableRooms(Session session, List<Hotel> hotels) {
        Query<?> theQuery =
                session.createQuery("update Room set enabled = false where hotel in :hotels");
        theQuery.setParameterList("hotels", hotels);
        theQuery.executeUpdate();
    }

    private void disableBookings(Session session, List<Hotel> hotels) {
        for (Hotel hotel: hotels) {
            Query<?> theQuery =
                    session.createQuery("update Booking set enabled = false where room in :rooms");
            theQuery.setParameterList("rooms", hotel.getRooms());
            theQuery.executeUpdate();
        }
    }
}


