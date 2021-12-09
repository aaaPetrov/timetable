package com.solvd.timetable.domain.timetable;

import java.util.Arrays;
import java.util.List;

public class TimeTable {

    private static TimeTable instance;
    private List<LessonBlock> lessonBlocks;

    private TimeTable(int size) {
        this.lessonBlocks = Arrays.asList(new LessonBlock[size]);
    }

    public List<LessonBlock> getLessonBlocks() {
        return lessonBlocks;
    }

    public void setLessonBlocks(List<LessonBlock> lessonBlocks) {
        this.lessonBlocks = lessonBlocks;
    }

    public static TimeTable getInstance(int size) {
        if(instance == null) {
            instance = new TimeTable(size);
        }
        return instance;
    }

}
