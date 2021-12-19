package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.TimeTableService;
import com.solvd.timetable.service.impl.TimeTableServiceImpl;

import java.util.Scanner;

public class Menu {

    public void menuPrinting() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nMenu:\n" +
                    "1. Print existing timetable\n" +
                    "2. Create new timetable with simple algorithm\n" +
                    "3. Create new timetable with genetic algorithm\n" +
                    "4. Exit menu");
            System.out.println("Choose option: ");
            Integer option = scanner.nextInt();
            TimeTableService timeTableService = new TimeTableServiceImpl();
            switch (option) {
                case 1:
                    TimeTable timeTable = timeTableService.getTimeTable();
                    if (timeTable.getLessonBlocks().size() != 0) {
                        System.out.println("Printing timetable");
                    } else {
                        System.out.println("Timetable is empty");
                    }
                    continue;
                case 2:
                    final int daysInWeek = chooseDaysInWeek();
                    Algorithm algorithm = new Algorithm(daysInWeek);
                    TimeTable newTimeTable = algorithm.createTimeTable();
                    timeTableService.createTimeTable(newTimeTable);
                    System.out.println("Printing timetable");
                    continue;
                case 3:
                    final int daysInWeekGenetic = chooseDaysInWeek();
                    Genetic genetic = new Genetic(daysInWeekGenetic);
                    TimeTable timeTableGenetic = genetic.tryGenetic();
                    timeTableService.createTimeTable(timeTableGenetic);
                    System.out.println("Printing timetable");
                    continue;
                case 4:
                    System.out.println("The program completed");
                    return;
                default:
                    System.out.println("You entered wrong value");
            }
        }
    }

    private static int chooseDaysInWeek() {
        int result = -1;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of days in the school week(5 or 6): ");
            result = scanner.nextInt();
            if (result < 5 && result > 6) {
                System.out.println("You entered the wrong number of days(" + result + ").");
                System.out.println("Try again...");
                continue;
            } else {
                break;
            }
        }
        return result;
    }
}
