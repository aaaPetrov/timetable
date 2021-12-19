package com.solvd.timetable.domain.timetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    @Override
    public String toString() {
        return "TimeTable\n" + lessonBlocks;
    }

    public void printTable(TimeTable newTimeTable) {
        //       System.out.println(newTimeTable);
        System.out.println("Grade");
        System.out.println("Day");
        System.out.println("Lesson number || Lesson time || Subject || Room || Teacher \n\n");

        List<String> gradesName = Arrays.asList("7A", "7B","8A","8B");
        List<Day> workDays = Arrays.asList(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY);
        for (int i = 0; i < gradesName.size(); i++) {
            System.out.println("\n\n\n\t\t\t\t" + gradesName.get(i));

            for (int d = 0; d < workDays.size(); d++) {
                System.out.println("\n\t\t\t\t" + workDays.get(d));

                for (int j = 0; j < newTimeTable.getLessonBlocks().size(); j++) {
                    if (newTimeTable.getLessonBlocks().get(j) != null) {

                        if (newTimeTable.getLessonBlocks().get(j).getGrade().getName().equals(gradesName.get(i)) &&
                        newTimeTable.getLessonBlocks().get(j).getDay().equals(workDays.get(d))) {
                            System.out.print("\n " + newTimeTable.getLessonBlocks().get(j).getLessonNumber().getId());
                            System.out.println(newTimeTable.getLessonBlocks().get(j));
                        }

                    }
                }
            }
        }

    }
}
