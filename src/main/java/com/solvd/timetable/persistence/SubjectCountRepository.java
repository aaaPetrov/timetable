package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.SubjectCount;

import java.util.List;

public interface SubjectCountRepository {

    List<SubjectCount> getSubjectCounts();
}
