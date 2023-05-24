package com.nltu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nltu.entity.Hotel;

@Repository
public class HotelDAOimpl implements HotelDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
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
		
//		//create a query
//		Query<Hotel> theQuery = 
//				currentSession.createQuery("from Hotel WHERE id = "+id, Hotel.class);
//		
//		//execute query and get result list
//		Hotel hotel = theQuery.getSingleResult();
//		
//		//return the results
//		return hotel;
		
		return currentSession.get(Hotel.class, id);
	}

}
