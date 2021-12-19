package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.Teacher;
import com.solvd.timetable.persistence.Impl.TeacherRepositoryImpl;
import com.solvd.timetable.persistence.TeacherRepository;
import com.solvd.timetable.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl() {
        this.teacherRepository = new TeacherRepositoryImpl();
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.getTeachers();
    }

}
