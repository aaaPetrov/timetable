package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.TimetableService;
import com.solvd.timetable.service.impl.TimetableServiceImpl;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days in the school week(5 or 6): ");
        final int daysInWeek = scanner.nextInt();

        Algorithm algorithm = new Algorithm(daysInWeek);
        TimeTable timeTable = algorithm.createTimeTable();

        TimetableService timetableService = new TimetableServiceImpl();
        timetableService.createTimetable(timeTable);

        TimeTable newTimeTable = timetableService.getTimeTable();
        System.out.println();
    }

}