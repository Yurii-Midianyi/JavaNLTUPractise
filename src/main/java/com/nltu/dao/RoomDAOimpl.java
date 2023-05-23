package com.nltu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nltu.entity.Room;

@Repository
public class RoomDAOimpl implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Room> getRooms(int hotelId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query
		Query<Room> theQuery = 
				currentSession.createQuery("from Room WHERE hotel.id = " + hotelId, Room.class);
				
		
		//execute query and get result list
		List<Room> rooms = theQuery.getResultList();
				
		//return the results
		return rooms;
	}
	
	

}
