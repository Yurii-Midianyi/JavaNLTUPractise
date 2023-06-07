package com.nltu.service;

import java.util.List;

import com.nltu.entity.Room;

public interface RoomService {
	
	public List<Room> getRoomsOfHotel(int hotelId);
	
	public List<Room> getAllRooms();

	public List<Room> getAvailableRooms(int hotelId);
	
	public void saveRoom(Room room);

	public Room getRoom(int roomId);

	public void deleteRoom(int roomId);

	public Boolean checkRoomExists(int roomNumber, int hotelId);
}
