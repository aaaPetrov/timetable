package com.solvd.timetable.service.impl;

import com.solvd.timetable.algorithm.TeacherWish;
import com.solvd.timetable.persistence.Impl.TeacherWishesRepositoryImpl;
import com.solvd.timetable.persistence.TeacherWishesRepository;
import com.solvd.timetable.service.TeacherWishService;

import java.util.List;

public class TeacherWishServiceImpl implements TeacherWishService {

    private final TeacherWishesRepository teacherWishesRepository;

    public TeacherWishServiceImpl() {
        this.teacherWishesRepository = new TeacherWishesRepositoryImpl();
    }

    @Override
    public List<TeacherWish> getAll() {
        return teacherWishesRepository.getTeacherWishes();
    }

}
