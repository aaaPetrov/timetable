package com.solvd.timetable.persistence;

import com.solvd.timetable.algorithm.SubjectArea;

import java.util.List;

public interface SubjectAreaRepository {

    List<SubjectArea> getSubjectAreas();

}
