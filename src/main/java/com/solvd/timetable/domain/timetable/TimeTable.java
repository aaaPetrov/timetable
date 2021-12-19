package com.solvd.timetable.domain.timetable;

import com.solvd.timetable.domain.Grade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TimeTable {

    private List<LessonBlock> lessonBlocks;

    public TimeTable() {
    }

    public TimeTable(int size) {
        this.lessonBlocks = Arrays.asList(new LessonBlock[size]);
    }

    public List<LessonBlock> getLessonBlocks() {
        return lessonBlocks;
    }

    public void setLessonBlocks(List<LessonBlock> lessonBlocks) {
        this.lessonBlocks = lessonBlocks;
    }

    public void printTable(TimeTable timeTable) {
        List<Grade> grades = gradesInTimetable(timeTable.getLessonBlocks());
        List<Day> days = daysInWeek(timeTable.getLessonBlocks());

        for (int i = 0; i < grades.size(); i++) {
            System.out.println("\n\n\n\t\t\t\t\t\t\t\t" + grades.get(i).getName());

            for (int d = 0; d < days.size(); d++) {
                System.out.println("\n\t\t\t\t\t\t\t\t" + days.get(d).name());

                for (int j = 0; j < timeTable.getLessonBlocks().size(); j++) {
                    if (timeTable.getLessonBlocks().get(j) != null) {
                        if (timeTable.getLessonBlocks().get(j).getGrade().getName().equals(grades.get(i).getName()) &&
                                timeTable.getLessonBlocks().get(j).getDay().equals(days.get(d))) {
                            System.out.print("\n " + timeTable.getLessonBlocks().get(j).getLessonNumber().getId());
                            System.out.println(timeTable.getLessonBlocks().get(j));
                        }
                    }
                }
            }
        }
        System.out.println("\n");
    }

    private List<Day> daysInWeek(List<LessonBlock> lessonBlocks) {
        List<Day> daysInTimetable = new ArrayList<>();
        for (LessonBlock lessonBlock : lessonBlocks) {
            if (lessonBlock != null) {
                if (daysInTimetable.isEmpty()) {
                    daysInTimetable.add(lessonBlock.getDay());
                    continue;
                } else {
                    int dayCount = 0;
                    for (Day day : daysInTimetable) {
                        if (!day.name().equals(lessonBlock.getDay().name())) {
                            dayCount++;
                        }
                    }
                    if (dayCount == daysInTimetable.size()) {
                        daysInTimetable.add(lessonBlock.getDay());
                    }
                }
            }
        }
        return  daysInTimetable;
    }

    private List<Grade> gradesInTimetable(List<LessonBlock> lessonBlocks) {
        List<Grade> gradesInTimetable = new ArrayList<>();
        for (LessonBlock lessonBlock : lessonBlocks) {
            if (lessonBlock != null) {
                if (gradesInTimetable.isEmpty()) {
                    gradesInTimetable.add(lessonBlock.getGrade());
                    continue;
                } else {
                    int gradeCount = 0;
                    for (Grade grade : gradesInTimetable) {
                        if (!grade.getName().equals(lessonBlock.getGrade().getName())) {
                            gradeCount++;
                        }
                    }
                    if (gradeCount == gradesInTimetable.size()) {
                        gradesInTimetable.add(lessonBlock.getGrade());
                    }
                }
            }
        }
        return  gradesInTimetable;
    }

}
