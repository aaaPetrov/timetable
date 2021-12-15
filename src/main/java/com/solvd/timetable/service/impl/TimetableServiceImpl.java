package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.persistence.Impl.TimetableRepositoryImpl;
import com.solvd.timetable.persistence.TimetableRepository;
import com.solvd.timetable.service.TimetableService;

import java.util.List;

public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl() {
        this.timetableRepository = new TimetableRepositoryImpl();
    }

    @Override
    public void createTimetable(TimeTable timeTable) {
        List<LessonBlock> lessonBlocks = timeTable.getLessonBlocks();
        lessonBlocks.stream()
                .filter(lessonBlock -> lessonBlock != null)
                .forEach(timetableRepository::createTimetable);
    }
}