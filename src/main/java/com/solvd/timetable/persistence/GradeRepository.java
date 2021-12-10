package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.Grade;

import java.util.List;

public interface GradeRepository {

    List<Grade> getGrades();
}
