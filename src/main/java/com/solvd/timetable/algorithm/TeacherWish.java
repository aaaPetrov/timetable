package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.Teacher;

import java.util.List;

public class TeacherWish {

    private Long id;
    private Teacher teacher;
    private List<Integer> wishes;

    public TeacherWish() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Integer> getWishes() {
        return wishes;
    }

    public void setWishes(List<Integer> wishes) {
        this.wishes = wishes;
    }

}
