package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.*;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.*;
import com.solvd.timetable.service.impl.*;

import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> grades = gradeService.getAll();
        RoomService roomService = new RoomServiceImpl();
        List<Room> rooms = roomService.getAll();
        TeacherService teacherService = new TeacherServiceImpl();
        List<Teacher> teachers = teacherService.getAll();
        GradeCurriculumService gradeCurriculumService = new GradeCurriculumServiceImpl();
        List<GradeCurriculum> gradeCurricula = gradeCurriculumService.getAll();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days in the school week(5 or 6): ");
        final int daysInWeek = scanner.nextInt();
        Algorithm algorithm = new Algorithm(daysInWeek, grades, teachers, rooms, gradeCurricula);
        TimeTable timeTable = algorithm.createTimeTable();
    }

}