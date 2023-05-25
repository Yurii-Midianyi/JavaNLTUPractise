package com.nltu.dao;

import java.util.List;
import com.nltu.entity.Room;

public interface RoomDAO {
	public List<Room> getRooms(int hotelId);

	public void saveRoom(Room room);
}