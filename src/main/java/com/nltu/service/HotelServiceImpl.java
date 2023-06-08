package com.nltu.service;

import com.nltu.dao.HotelDAO;
import com.nltu.entity.Country;
import com.nltu.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    private final SessionFactory sessionFactory;
    private final HotelDAO hotelDAO;
    @Autowired
    public HotelServiceImpl(SessionFactory sessionFactory, HotelDAO hotelDAO) {
        this.sessionFactory = sessionFactory;
        this.hotelDAO = hotelDAO;
    }

    @Override
    @Transactional
    public List<Hotel> getHotels() { // i didn`t change it, bcz i don`t understand it
//        //get current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        //create a query
//        Query<Hotel> theQuery =
//                currentSession.createQuery("from Hotel", Hotel.class);
//
//        //execute query and get result list
//        List<Hotel> hotels = theQuery.getResultList();
//
//        //return the results
//        return hotels;
        return hotelDAO.getHotels();
    }

    @Override
    @Transactional
    public Hotel getHotel(int id) {
        return hotelDAO.getHotel(id);
    }

    @Override
    @Transactional
    public Hotel show(int id) {
        return hotelDAO.show(id);
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    @Override
    @Transactional
    public void update(int id, Hotel updateHotel) {
       hotelDAO.update(id, updateHotel);
    }

    @Override
    @Transactional
    public void delete(int id) {
        hotelDAO.delete(id);
    }

    @Override
    @Transactional
    public Boolean checkHotelExists(String hotelName, int countryId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Hotel> theQuery =
                currentSession.createQuery("from Hotel where hotelName = :hotelName" +
                        " and country.id = :countryId", Hotel.class);
        theQuery.setParameter("hotelName", hotelName);
        theQuery.setParameter("countryId", countryId);

        List<Hotel> hotels = theQuery.getResultList();

        return !hotels.isEmpty();
    }
}
