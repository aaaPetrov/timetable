package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.TimeTableService;
import com.solvd.timetable.service.impl.TimeTableServiceImpl;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        //Выбираем количество дней
        final int daysInWeek = chooseDaysInWeek();

        //Алгоритм и его запуск ( createTimeTable )
        //Результат - созданый объект timeTable с нашим расписанием.
        Algorithm algorithm = new Algorithm(daysInWeek);
        TimeTable timeTable = algorithm.createTimeTable();

        //Генетический алгоритм
        /*Genetic genetic = new Genetic(daysInWeek);
        TimeTable timeTable = genetic.tryGenetic();*/

        //Функция createTimeTable() удаляет все данные из таблицы timetable в БД
        //А после делает insert в БД, в таблицу timetable наще расписание.
        TimeTableService timeTableService = new TimeTableServiceImpl();
        timeTableService.createTimeTable(timeTable);

        //Функция getTimeTable возвращает из базы данных расписание внутри объекта TimeTable.
        TimeTable newTimeTable = timeTableService.getTimeTable();
        timeTable.printTable(newTimeTable);
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