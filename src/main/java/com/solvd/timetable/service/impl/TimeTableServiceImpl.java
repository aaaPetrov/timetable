package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.persistence.Impl.TimeTableRepositoryImpl;
import com.solvd.timetable.persistence.TimeTableRepository;
import com.solvd.timetable.service.TimeTableService;

import java.util.List;

public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository timeTableRepository;

    public TimeTableServiceImpl() {
        this.timeTableRepository = new TimeTableRepositoryImpl();
    }

    @Override
    public void createTimeTable(TimeTable timeTable) {
        List<LessonBlock> lessonBlocks = timeTable.getLessonBlocks();
        lessonBlocks.stream()
                .filter(lessonBlock -> lessonBlock != null)
                .forEach(timeTableRepository::createTimeTable);
    }

    @Override
    public TimeTable getTimeTable() {
        List<LessonBlock> lessonBlocks = timeTableRepository.getLessonBlocks();
        TimeTable timeTable = new TimeTable();
        timeTable.setLessonBlocks(lessonBlocks);
        return timeTable;
    }


}
