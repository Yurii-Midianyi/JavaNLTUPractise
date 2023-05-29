package com.nltu.service;

import com.nltu.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    private final SessionFactory sessionFactory;

    @Autowired
    public HotelServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Hotel> getHotels() {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query
        Query<Hotel> theQuery =
                currentSession.createQuery("from Hotel", Hotel.class);

        //execute query and get result list
        List<Hotel> hotels = theQuery.getResultList();

        //return the results
        return hotels;
    }

    @Override
    @Transactional
    public Hotel getHotel(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Hotel.class, id);
    }

    @Override
    @Transactional
    public Hotel show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Hotel.class, id);
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
    }

    @Override
    @Transactional
    public void update(int id, Hotel updateHotel) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotelToBeUpdated = session.get(Hotel.class, id);

        hotelToBeUpdated.setHotelName(updateHotel.getHotelName());
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Hotel.class, id));
    }
}
