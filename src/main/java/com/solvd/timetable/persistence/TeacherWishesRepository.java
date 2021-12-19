package com.solvd.timetable.persistence;

import com.solvd.timetable.algorithm.TeacherWish;

import java.util.List;

public interface TeacherWishesRepository {

    List<TeacherWish> getTeacherWishes();
}
