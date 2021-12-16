package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.Grade;
import com.solvd.timetable.domain.GradeCurriculum;
import com.solvd.timetable.domain.Room;
import com.solvd.timetable.domain.Teacher;
import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.persistence.GradeCurriculumRepository;
import com.solvd.timetable.persistence.Impl.GradeCurriculumRepositoryImpl;
import com.solvd.timetable.persistence.Impl.LessonBlockRepositoryImpl;
import com.solvd.timetable.persistence.Impl.TimetableRepositoryImpl;
import com.solvd.timetable.persistence.LessonBlockRepository;
import com.solvd.timetable.persistence.TimetableRepository;
import com.solvd.timetable.service.GradeCurriculumService;
import com.solvd.timetable.service.GradeService;
import com.solvd.timetable.service.RoomService;
import com.solvd.timetable.service.TeacherService;
import com.solvd.timetable.service.impl.GradeCurriculumServiceImpl;
import com.solvd.timetable.service.impl.GradeServiceImpl;
import com.solvd.timetable.service.impl.RoomServiceImpl;
import com.solvd.timetable.service.impl.TeacherServiceImpl;

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

        LessonBlockRepository lessonBlockRepository = new LessonBlockRepositoryImpl();
        List<LessonBlock> lessonBlocks = lessonBlockRepository.getLessonBlocks();
    }

}