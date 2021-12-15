package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.timetable.LessonBlock;

import java.util.List;

public interface LessonBlockRepository {

    List<LessonBlock> getLessonBlocks();
}
