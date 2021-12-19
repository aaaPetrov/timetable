package com.solvd.timetable.persistence;

import com.solvd.timetable.algorithm.SubjectComplexity;

import java.util.List;

public interface SubjectComplexityRepository {

    List<SubjectComplexity> getSubjectComplexities();

}
