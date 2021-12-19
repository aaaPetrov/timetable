package com.solvd.timetable.persistence;

import com.solvd.timetable.algorithm.DayComplexity;

import java.util.List;

public interface DayComplexityRepository {

    List<DayComplexity> getDayComplexities();

}
