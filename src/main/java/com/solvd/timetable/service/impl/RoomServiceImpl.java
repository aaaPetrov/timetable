package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.Room;
import com.solvd.timetable.persistence.Impl.RoomRepositoryImpl;
import com.solvd.timetable.persistence.RoomRepository;
import com.solvd.timetable.service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.getRooms();
    }

}
