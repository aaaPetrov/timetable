package com.solvd.timetable.domain;

public class Room {

    private Long id;
    private String number;
    private RoomType roomType;

    public Room() {}

    public enum RoomType {
        LAB, GYM, MAP, ALL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

}