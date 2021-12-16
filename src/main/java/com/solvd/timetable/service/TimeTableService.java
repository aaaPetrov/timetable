package com.solvd.timetable.service;


import com.solvd.timetable.domain.timetable.TimeTable;

public interface TimeTableService {

    void createTimeTable(TimeTable timeTable);

    TimeTable getTimeTable();

}
