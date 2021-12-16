package com.solvd.timetable.domain.timetable;

import java.util.Arrays;
import java.util.List;

public class TimeTable {

    private List<LessonBlock> lessonBlocks;

    public TimeTable() {}

    public TimeTable(int size) {
        this.lessonBlocks = Arrays.asList(new LessonBlock[size]);
    }

    public List<LessonBlock> getLessonBlocks() {
        return lessonBlocks;
    }

    public void setLessonBlocks(List<LessonBlock> lessonBlocks) {
        this.lessonBlocks = lessonBlocks;
    }

}
