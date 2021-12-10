package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.Teacher;

import java.util.List;

public interface TeacherRepository {

    List<Teacher> getTeachers();
}
