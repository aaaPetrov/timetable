package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.algorithm.Genetic;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.TimeTableService;
import com.solvd.timetable.service.impl.TimeTableServiceImpl;

import java.util.Scanner;

public class Menu {

    public void menuPrinting() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nMenu:\n" +
                    "1. Print existing timetable.\n" +
                    "2. Create and print new timetable with our own algorithm.\n" +
                    "3. Create and print new timetable with genetic algorithm.\n" +
                    "4. Exit menu.");
            System.out.println("\nChoose option: ");
            int option = scanner.nextInt();
            TimeTableService timeTableService = new TimeTableServiceImpl();
            switch (option) {
                case 1:
                    TimeTable timeTable = timeTableService.getTimeTable();
                    if (timeTable.getLessonBlocks().size() != 0) {
                        timeTable.printTable();
                    } else {
                        System.out.println("There is no existing timetable.");
                    }
                    continue;
                case 2:
                    System.out.println("\n\nPlease wait. It can takes from 10 seconds to 5 minutes.\n\n");
                    final int daysInWeek = chooseDaysInWeek();
                    Algorithm algorithm = new Algorithm(daysInWeek);
                    TimeTable newTimeTable = algorithm.createTimeTable();
                    timeTableService.createTimeTable(newTimeTable);
                    newTimeTable.printTable();
                    continue;
                case 3:
                    final int daysInWeekGenetic = chooseDaysInWeek();
                    System.out.println("\n\nPlease wait. It will take 20-25 minutes.\n\n");
                    Genetic genetic = new Genetic(daysInWeekGenetic);
                    TimeTable timeTableGenetic = genetic.tryGenetic();
                    timeTableService.createTimeTable(timeTableGenetic);
                    timeTableGenetic.printTable();
                    continue;
                case 4:
                    System.out.println("EXIT.\n\n");
                    System.exit(0);
                default:
                    System.out.println("You entered wrong value.");
            }
        }
    }

    private static int chooseDaysInWeek() {
        int result;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of days in the school week(5 or 6): ");
            result = scanner.nextInt();
            if (result < 5 && result > 6) {
                System.out.println("You entered the wrong number of days(" + result + ").");
                System.out.println("Try again...");
            } else {
                break;
            }
        }
        return result;
    }

}
