package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.Room;

import java.util.List;

public interface RoomRepository {

    List<Room> getRooms();
}
