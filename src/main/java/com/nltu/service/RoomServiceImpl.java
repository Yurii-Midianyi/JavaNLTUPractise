package com.nltu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nltu.dao.HotelDAO;
import com.nltu.dao.RoomDAO;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDAO roomDAO;
	
	@Autowired
	private HotelDAO hotelDAO;
	
	@Override
	@Transactional
	public void saveRoom(Room room) {
		
		Hotel hotel = hotelDAO.getHotel(room.getHotel().getId());

	    // Set the managed hotel on the room
	    room.setHotel(hotel);

	    // Save the room
	    roomDAO.saveRoom(room);
	}

	@Override
	@Transactional
	public List<Room> getRooms(int hotelId) {
		return roomDAO.getRooms(hotelId);
	}

}
