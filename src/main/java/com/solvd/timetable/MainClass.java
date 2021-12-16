package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.TimeTableService;
import com.solvd.timetable.service.impl.TimeTableServiceImpl;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days in the school week(5 or 6): ");
        final int daysInWeek = scanner.nextInt();

        //Алгоритм и его запуск ( createTimeTable )
        //Результат - созданый объект timeTable с нашим расписанием.
        Algorithm algorithm = new Algorithm(daysInWeek);
        TimeTable timeTable = algorithm.createTimeTable();

        //Функция createTimeTable() удаляет все данные из таблицы timetable в БД
        //А после делает insert в БД, в таблицу timetable наще расписание.
        TimeTableService timeTableService = new TimeTableServiceImpl();
        timeTableService.createTimeTable(timeTable);

        //Функция getTimeTable возвращает из базы данных расписание внутри объекта TimeTable.
        TimeTable newTimeTable = timeTableService.getTimeTable();

        //Функция formatTimeTable приводит наше расписание в удобный для вывода вид.
        newTimeTable = algorithm.formatTimeTable(newTimeTable);
        System.out.println();
    }

}