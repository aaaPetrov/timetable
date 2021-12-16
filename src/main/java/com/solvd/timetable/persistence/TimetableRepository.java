package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.timetable.LessonBlock;

import java.util.List;

public interface TimetableRepository {

    void createTimetable(LessonBlock lessonBlocks);

    List<LessonBlock> getLessonBlocks();

}
