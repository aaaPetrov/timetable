package com.solvd.timetable.domain;

public class Subject {

    private Long id;
    private String name;
    private roomTypeNeeded roomTypeNeeded;

    public Subject() {}

    public enum roomTypeNeeded {
        LAB, GYM, MAP, ALL
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

    public Subject.roomTypeNeeded getRoomTypeNeeded() {
        return roomTypeNeeded;
    }

    public void setRoomTypeNeeded(Subject.roomTypeNeeded roomTypeNeeded) {
        this.roomTypeNeeded = roomTypeNeeded;
    }

}
