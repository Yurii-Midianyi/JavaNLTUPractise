package com.nltu.dao;

import java.util.List;

import com.nltu.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nltu.entity.Hotel;

@Repository
public class HotelDAOimpl implements HotelDAO {

	private final SessionFactory sessionFactory;
	@Autowired
	public HotelDAOimpl(SessionFactory sessionFactory) {
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

	@Transactional(readOnly = true)
	public Hotel show (int id){
		Session session = sessionFactory.getCurrentSession();
		return session.get(Hotel.class, id);
	}

	@Transactional
	public void save(Hotel hotel) {
      Session session = sessionFactory.getCurrentSession();
	  session.save(hotel);
	}

	@Transactional
	public void update(int id, Hotel updateHotel) {
     Session session = sessionFactory.getCurrentSession();
	 Hotel hotelToBeUpdated = session.get(Hotel.class, id);

	 hotelToBeUpdated.setHotelName(updateHotel.getHotelName());
	}

    @Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Hotel hotel = session.get(Hotel.class, id);

		if (!bookingsExist(hotel)) {
			session.remove(hotel);
		}
		else { //need to rewrite this
			Query<?> theQuery = session.createQuery("update Hotel set enabled = false where id = :id");
			theQuery.setParameter("id", id);
			theQuery.executeUpdate();

			theQuery = session.createQuery("update Room set enabled = false where hotel = :hotel");
			theQuery.setParameter("hotel", hotel);
			theQuery.executeUpdate();

			for (Room room: hotel.getRooms()) {
				theQuery = session.createQuery("update Booking set enabled = false where room = :room");
				theQuery.setParameter("room", room);
				theQuery.executeUpdate();
			}
		}
	}

	private Boolean bookingsExist(Hotel hotel) {
		for (Room room: hotel.getRooms()) {
			if (!room.getBookings().isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
