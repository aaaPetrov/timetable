package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.timetable.LessonBlock;

import java.util.List;

public interface TimeTableRepository {

    void createTimeTable(LessonBlock lessonBlocks);

    List<LessonBlock> getLessonBlocks();

}
