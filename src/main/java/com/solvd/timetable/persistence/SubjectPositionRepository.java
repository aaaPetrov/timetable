package com.solvd.timetable.persistence;

import com.solvd.timetable.algorithm.SubjectPosition;

import java.util.List;

public interface SubjectPositionRepository {

    List<SubjectPosition> getSubjectPositions();
}
