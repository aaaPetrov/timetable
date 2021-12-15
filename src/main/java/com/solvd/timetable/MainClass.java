package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.persistence.Impl.LessonBlockRepositoryImpl;
import com.solvd.timetable.persistence.Impl.TimetableRepositoryImpl;
import com.solvd.timetable.persistence.LessonBlockRepository;
import com.solvd.timetable.persistence.TimetableRepository;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days in the school week(5 or 6): ");
        final int daysInWeek = scanner.nextInt();

        Algorithm algorithm = new Algorithm(daysInWeek);
        TimeTable timeTable = algorithm.createTimeTable();

        LessonBlockRepository lessonBlockRepository = new LessonBlockRepositoryImpl();
        TimetableRepository timetableRepository = new TimetableRepositoryImpl();

        for(LessonBlock lessonBlock : timeTable.getLessonBlocks()) {
            timetableRepository.createTimetable(lessonBlock);
        }

        List<LessonBlock> lessonBlocks = lessonBlockRepository.getLessonBlocks();
    }

}