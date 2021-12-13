package com.solvd.timetable.domain;

public class Subject {

    private Long id;
    private String name;
    private RoomTypeNeeded roomTypeNeeded;

    public Subject() {
    }

    public enum RoomTypeNeeded {
        LAB, GYM, MAP, ALL, COMPUTER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomTypeNeeded getRoomTypeNeeded() {
        return roomTypeNeeded;
    }

    public void setRoomTypeNeeded(RoomTypeNeeded roomTypeNeeded) {
        this.roomTypeNeeded = roomTypeNeeded;
    }
}
