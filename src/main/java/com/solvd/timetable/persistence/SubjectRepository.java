package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> getSubjects();
}
