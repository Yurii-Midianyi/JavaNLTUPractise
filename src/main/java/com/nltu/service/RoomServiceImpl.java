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

	@Override
	@Transactional
	public Room getRoom(int roomId) {
		return roomDAO.getRoom(roomId);
	}

	@Override
	@Transactional
	public void deleteRoom(int roomId) {
		roomDAO.deleteRoom(roomId);
	}

	@Override
	@Transactional
	public List<Room> getAllRooms() { 
		return roomDAO.getRooms();
	}

	@Override
	@Transactional
	public List<Room> getAvailableRooms(int hotelId) {
		return roomDAO.getAvailableRooms(hotelId);	
	}
}
