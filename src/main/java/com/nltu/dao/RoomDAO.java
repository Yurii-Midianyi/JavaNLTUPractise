package com.nltu.dao;

import java.util.List;
import com.nltu.entity.Room;

public interface RoomDAO {
	public List<Room> getRoomsOfHotel(int hotelId);

	public void saveRoom(Room room);

	public Room getRoom(int roomId);

	public void deleteRoom(int roomId);

	public List<Room> getAllRooms();

	public List<Room> getAvailableRooms(int hotelId);
	
}
