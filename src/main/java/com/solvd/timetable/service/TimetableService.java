package com.solvd.timetable.service;

import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.domain.timetable.TimeTable;

import java.util.List;

public interface TimetableService {

    void createTimetable(TimeTable timeTable);

    TimeTable getTimeTable();

}
