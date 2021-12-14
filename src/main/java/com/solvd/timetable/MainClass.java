package com.solvd.timetable;

import com.solvd.timetable.algorithm.Algorithm;
import com.solvd.timetable.domain.*;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.service.*;
import com.solvd.timetable.service.impl.*;

import java.util.Arrays;
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

    private static List<Grade> createGrades() {
        Grade grade1 = new Grade();
        grade1.setId(1L);
        grade1.setName("7A");
        Grade grade2 = new Grade();
        grade2.setId(2L);
        grade2.setName("7B");
        Grade grade3 = new Grade();
        grade3.setId(3L);
        grade3.setName("8A");
        Grade grade4 = new Grade();
        grade4.setId(4L);
        grade4.setName("8B");

        return Arrays.asList(grade1, grade2, grade3, grade4);
    }

    private static List<Room> createRooms() {
        Room room1 = new Room();
        room1.setId(1L);
        room1.setNumber("25");
        room1.setRoomType(Room.RoomType.MAP);
        Room room2 = new Room();
        room2.setId(2L);
        room2.setNumber("37");
        room2.setRoomType(Room.RoomType.MAP);
        Room room3 = new Room();
        room3.setId(3L);
        room3.setNumber("26");
        room3.setRoomType(Room.RoomType.ALL);
        Room room4 = new Room();
        room4.setId(4L);
        room4.setNumber("39");
        room4.setRoomType(Room.RoomType.ALL);
        Room room5 = new Room();
        room5.setId(5L);
        room5.setNumber("35");
        room5.setRoomType(Room.RoomType.ALL);
        Room room6 = new Room();
        room6.setId(6L);
        room6.setNumber("30");
        room6.setRoomType(Room.RoomType.COMPUTER);
        Room room7 = new Room();
        room7.setId(7L);
        room7.setNumber("33");
        room7.setRoomType(Room.RoomType.LAB);
        Room room8 = new Room();
        room8.setId(8L);
        room8.setNumber("32");
        room8.setRoomType(Room.RoomType.LAB);
        Room room9 = new Room();
        room9.setId(9L);
        room9.setNumber("38");
        room9.setRoomType(Room.RoomType.LAB);
        Room room10 = new Room();
        room10.setId(10L);
        room10.setNumber("28");
        room10.setRoomType(Room.RoomType.ALL);
        Room room11 = new Room();
        room11.setId(11L);
        room11.setNumber("13");
        room11.setRoomType(Room.RoomType.GYM);

        return Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11);
    }

    private static List<Subject> createSubject() {
        Subject subject1 = new Subject();
        subject1.setId(1L);
        subject1.setName("History");
        subject1.setRoomTypeNeeded(Subject.RoomTypeNeeded.MAP);
        Subject subject2 = new Subject();
        subject2.setId(2L);
        subject2.setName("Geography");
        subject2.setRoomTypeNeeded(Subject.RoomTypeNeeded.MAP);
        Subject subject3 = new Subject();
        subject3.setId(3L);
        subject3.setName("Russian Language");
        subject3.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject4 = new Subject();
        subject4.setId(4L);
        subject4.setName("Russian Literature");
        subject4.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject5 = new Subject();
        subject5.setId(5L);
        subject5.setName("English Language");
        subject5.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject6 = new Subject();
        subject6.setId(6L);
        subject6.setName("Algebra");
        subject6.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject7 = new Subject();
        subject7.setId(7L);
        subject7.setName("Geometry");
        subject7.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject8 = new Subject();
        subject8.setId(8L);
        subject8.setName("Informatics");
        subject8.setRoomTypeNeeded(Subject.RoomTypeNeeded.COMPUTER);
        Subject subject9 = new Subject();
        subject9.setId(9L);
        subject9.setName("Chemistry");
        subject9.setRoomTypeNeeded(Subject.RoomTypeNeeded.LAB);
        Subject subject10 = new Subject();
        subject10.setId(10L);
        subject10.setName("Biology");
        subject10.setRoomTypeNeeded(Subject.RoomTypeNeeded.LAB);
        Subject subject11 = new Subject();
        subject11.setId(11L);
        subject11.setName("Physics");
        subject11.setRoomTypeNeeded(Subject.RoomTypeNeeded.LAB);
        Subject subject12 = new Subject();
        subject12.setId(12L);
        subject12.setName("Social Science");
        subject12.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject13 = new Subject();
        subject13.setId(13L);
        subject13.setName("Physical Culture");
        subject13.setRoomTypeNeeded(Subject.RoomTypeNeeded.GYM);
        Subject subject14 = new Subject();
        subject14.setId(14L);
        subject14.setName("O.B.G.");
        subject14.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject15 = new Subject();
        subject15.setId(15L);
        subject15.setName("Music");
        subject15.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);
        Subject subject16 = new Subject();
        subject16.setId(16L);
        subject16.setName("Art");
        subject16.setRoomTypeNeeded(Subject.RoomTypeNeeded.ALL);

        return Arrays.asList(subject1, subject2, subject3, subject4, subject5, subject6,
                subject7, subject8, subject9, subject10, subject11, subject12, subject13, subject14, subject15, subject16);
    }

    private static List<Teacher> createTeachers(List<Subject> subjects) {
        Teacher teacher1 = new Teacher();
        teacher1.setId(1L);
        teacher1.setFirstName("Marina");
        teacher1.setLastName("Sergeevna");
        teacher1.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "History").findFirst().get(),
                subjects.stream().filter(subject -> subject.getName() == "Social Science").findFirst().get()));
        Teacher teacher2 = new Teacher();
        teacher2.setId(2L);
        teacher2.setFirstName("Natalia");
        teacher2.setLastName("Vasilevna");
        teacher2.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Geography").findFirst().get()));
        Teacher teacher3 = new Teacher();
        teacher3.setId(3L);
        teacher3.setFirstName("Natalia");
        teacher3.setLastName("Nikolaevna");
        teacher3.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Russian Language").findFirst().get(),
                subjects.stream().filter(subject -> subject.getName() == "Russian Literature").findFirst().get()));
        Teacher teacher4 = new Teacher();
        teacher4.setId(4L);
        teacher4.setFirstName("Alexandra");
        teacher4.setLastName("Sergeevna");
        teacher4.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "English Language").findFirst().get()));
        Teacher teacher5 = new Teacher();
        teacher5.setId(5L);
        teacher5.setFirstName("Elena");
        teacher5.setLastName("Igorevna");
        teacher5.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Algebra").findFirst().get(),
                subjects.stream().filter(subject -> subject.getName() == "Geometry").findFirst().get()));
        Teacher teacher6 = new Teacher();
        teacher6.setId(6L);
        teacher6.setFirstName("Uriy");
        teacher6.setLastName("Vladimirovich");
        teacher6.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Informatics").findFirst().get()));
        Teacher teacher7 = new Teacher();
        teacher7.setId(7L);
        teacher7.setFirstName("Vladimir");
        teacher7.setLastName("Vladimirovich");
        teacher7.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Chemistry").findFirst().get(),
                subjects.stream().filter(subject -> subject.getName() == "Physics").findFirst().get()));
        Teacher teacher8 = new Teacher();
        teacher8.setId(8L);
        teacher8.setFirstName("Vera");
        teacher8.setLastName("Prokopfievna");
        teacher8.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Biology").findFirst().get()));
        Teacher teacher9 = new Teacher();
        teacher9.setId(9L);
        teacher9.setFirstName("Pesenka");
        teacher9.setLastName("Pesenkova");
        teacher9.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Music").findFirst().get()));
        Teacher teacher10 = new Teacher();
        teacher10.setId(10L);
        teacher10.setFirstName("Kartina");
        teacher10.setLastName("Kartinovna");
        teacher10.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Art").findFirst().get()));
        Teacher teacher11 = new Teacher();
        teacher11.setId(11L);
        teacher11.setFirstName("Gnom");
        teacher11.setLastName("Liliputovich");
        teacher11.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "O.B.G.").findFirst().get()));
        Teacher teacher12 = new Teacher();
        teacher12.setId(12L);
        teacher12.setFirstName("JOOKOVSKI &");
        teacher12.setLastName("LOBODA");
        teacher12.setSubjects(Arrays.asList(subjects.stream().filter(subject -> subject.getName() == "Physical Culture").findFirst().get()));

        return Arrays.asList(teacher1, teacher2, teacher3, teacher4, teacher5, teacher6, teacher7, teacher8, teacher9, teacher10, teacher11, teacher12);
    }

    private static List<SubjectCount> createSubjectCounts1(List<Subject> subjects) {
        SubjectCount subjectCount1 = new SubjectCount();
        subjectCount1.setSubject(subjects.stream().filter(subject -> subject.getName() == "History").findFirst().get());
        subjectCount1.setCount(2);
        SubjectCount subjectCount2 = new SubjectCount();
        subjectCount2.setSubject(subjects.stream().filter(subject -> subject.getName() == "Geography").findFirst().get());
        subjectCount2.setCount(2);
        SubjectCount subjectCount3 = new SubjectCount();
        subjectCount3.setSubject(subjects.stream().filter(subject -> subject.getName() == "Russian Language").findFirst().get());
        subjectCount3.setCount(3);
        SubjectCount subjectCount4 = new SubjectCount();
        subjectCount4.setSubject(subjects.stream().filter(subject -> subject.getName() == "Russian Literature").findFirst().get());
        subjectCount4.setCount(2);
        SubjectCount subjectCount5 = new SubjectCount();
        subjectCount5.setSubject(subjects.stream().filter(subject -> subject.getName() == "Algebra").findFirst().get());
        subjectCount5.setCount(3);
        SubjectCount subjectCount6 = new SubjectCount();
        subjectCount6.setSubject(subjects.stream().filter(subject -> subject.getName() == "Geometry").findFirst().get());
        subjectCount6.setCount(2);
        SubjectCount subjectCount7 = new SubjectCount();
        subjectCount7.setSubject(subjects.stream().filter(subject -> subject.getName() == "Informatics").findFirst().get());
        subjectCount7.setCount(2);
        SubjectCount subjectCount8 = new SubjectCount();
        subjectCount8.setSubject(subjects.stream().filter(subject -> subject.getName() == "Biology").findFirst().get());
        subjectCount8.setCount(2);
        SubjectCount subjectCount9 = new SubjectCount();
        subjectCount9.setSubject(subjects.stream().filter(subject -> subject.getName() == "Physics").findFirst().get());
        subjectCount9.setCount(2);
        SubjectCount subjectCount10 = new SubjectCount();
        subjectCount10.setSubject(subjects.stream().filter(subject -> subject.getName() == "Social Science").findFirst().get());
        subjectCount10.setCount(1);
        SubjectCount subjectCount11 = new SubjectCount();
        subjectCount11.setSubject(subjects.stream().filter(subject -> subject.getName() == "Music").findFirst().get());
        subjectCount11.setCount(1);
        SubjectCount subjectCount12 = new SubjectCount();
        subjectCount12.setSubject(subjects.stream().filter(subject -> subject.getName() == "Physical Culture").findFirst().get());
        subjectCount12.setCount(3);
        SubjectCount subjectCount13 = new SubjectCount();
        subjectCount13.setSubject(subjects.stream().filter(subject -> subject.getName() == "Art").findFirst().get());
        subjectCount13.setCount(1);
        SubjectCount subjectCount14 = new SubjectCount();
        subjectCount14.setSubject(subjects.stream().filter(subject -> subject.getName() == "English Language").findFirst().get());
        subjectCount14.setCount(3);

        return Arrays.asList(subjectCount1, subjectCount2, subjectCount3, subjectCount4, subjectCount5, subjectCount6, subjectCount7, subjectCount8,
                subjectCount9, subjectCount10, subjectCount11, subjectCount12, subjectCount13, subjectCount14);
    }

    private static List<SubjectCount> createSubjectCounts2(List<Subject> subjects) {
        SubjectCount subjectCount1 = new SubjectCount();
        subjectCount1.setSubject(subjects.stream().filter(subject -> subject.getName() == "History").findFirst().get());
        subjectCount1.setCount(2);
        SubjectCount subjectCount2 = new SubjectCount();
        subjectCount2.setSubject(subjects.stream().filter(subject -> subject.getName() == "Geography").findFirst().get());
        subjectCount2.setCount(2);
        SubjectCount subjectCount3 = new SubjectCount();
        subjectCount3.setSubject(subjects.stream().filter(subject -> subject.getName() == "Russian Language").findFirst().get());
        subjectCount3.setCount(3);
        SubjectCount subjectCount4 = new SubjectCount();
        subjectCount4.setSubject(subjects.stream().filter(subject -> subject.getName() == "Russian Literature").findFirst().get());
        subjectCount4.setCount(2);
        SubjectCount subjectCount5 = new SubjectCount();
        subjectCount5.setSubject(subjects.stream().filter(subject -> subject.getName() == "Algebra").findFirst().get());
        subjectCount5.setCount(3);
        SubjectCount subjectCount6 = new SubjectCount();
        subjectCount6.setSubject(subjects.stream().filter(subject -> subject.getName() == "Geometry").findFirst().get());
        subjectCount6.setCount(2);
        SubjectCount subjectCount7 = new SubjectCount();
        subjectCount7.setSubject(subjects.stream().filter(subject -> subject.getName() == "Informatics").findFirst().get());
        subjectCount7.setCount(2);
        SubjectCount subjectCount8 = new SubjectCount();
        subjectCount8.setSubject(subjects.stream().filter(subject -> subject.getName() == "Chemistry").findFirst().get());
        subjectCount8.setCount(2);
        SubjectCount subjectCount9 = new SubjectCount();
        subjectCount9.setSubject(subjects.stream().filter(subject -> subject.getName() == "Biology").findFirst().get());
        subjectCount9.setCount(2);
        SubjectCount subjectCount10 = new SubjectCount();
        subjectCount10.setSubject(subjects.stream().filter(subject -> subject.getName() == "Physics").findFirst().get());
        subjectCount10.setCount(2);
        SubjectCount subjectCount11 = new SubjectCount();
        subjectCount11.setSubject(subjects.stream().filter(subject -> subject.getName() == "Social Science").findFirst().get());
        subjectCount11.setCount(1);
        SubjectCount subjectCount12 = new SubjectCount();
        subjectCount12.setSubject(subjects.stream().filter(subject -> subject.getName() == "Music").findFirst().get());
        subjectCount12.setCount(1);
        SubjectCount subjectCount13 = new SubjectCount();
        subjectCount13.setSubject(subjects.stream().filter(subject -> subject.getName() == "Physical Culture").findFirst().get());
        subjectCount13.setCount(3);
        SubjectCount subjectCount14 = new SubjectCount();
        subjectCount14.setSubject(subjects.stream().filter(subject -> subject.getName() == "O.B.G.").findFirst().get());
        subjectCount14.setCount(1);
        SubjectCount subjectCount15 = new SubjectCount();
        subjectCount15.setSubject(subjects.stream().filter(subject -> subject.getName() == "English Language").findFirst().get());
        subjectCount15.setCount(3);

        return Arrays.asList(subjectCount1, subjectCount2, subjectCount3, subjectCount4, subjectCount5, subjectCount6, subjectCount7, subjectCount8,
                subjectCount9, subjectCount10, subjectCount11, subjectCount12, subjectCount13, subjectCount14, subjectCount15);
    }

    private static List<GradeCurriculum> createGradeCurricula(List<Grade> grades, List<Subject> subjects) {
        GradeCurriculum gradeCurriculum1 = new GradeCurriculum();
        gradeCurriculum1.setGrade(grades.get(0));
        gradeCurriculum1.setCountSubjects(createSubjectCounts1(subjects));
        GradeCurriculum gradeCurriculum2 = new GradeCurriculum();
        gradeCurriculum2.setGrade(grades.get(1));
        gradeCurriculum2.setCountSubjects(createSubjectCounts1(subjects));
        GradeCurriculum gradeCurriculum3 = new GradeCurriculum();
        gradeCurriculum3.setGrade(grades.get(2));
        gradeCurriculum3.setCountSubjects(createSubjectCounts2(subjects));
        GradeCurriculum gradeCurriculum4 = new GradeCurriculum();
        gradeCurriculum4.setGrade(grades.get(3));
        gradeCurriculum4.setCountSubjects(createSubjectCounts2(subjects));
        return Arrays.asList(gradeCurriculum1, gradeCurriculum2, gradeCurriculum3, gradeCurriculum4);
    }
}