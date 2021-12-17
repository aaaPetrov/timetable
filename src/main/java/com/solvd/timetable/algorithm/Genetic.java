package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.*;
import com.solvd.timetable.domain.timetable.Day;
import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.domain.timetable.LessonNumber;
import com.solvd.timetable.domain.timetable.TimeTable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Genetic extends Algorithm {

    private List<List<LessonBlock>> bestPopulation;
    private List<List<LessonBlock>> currentPopulation;
    private List<SubjectComplexity> subjectСomplexities;
    private List<DayComplexity> dayComplexities;
    private List<SubjectArea> subjectAreas;
    private List<SubjectPosition> subjectPositions;
    private List<TeacherWish> teacherWishes;

    public Genetic(int daysInWeek) {
        super(daysInWeek);
        createStartPopulation();
        this.subjectСomplexities = null;
        this.dayComplexities = null;
        this.subjectAreas = null;
        this.bestPopulation = null;
        this.teacherWishes = null;
    }

    public TimeTable tryGenetic() {


        return null;
    }

    private void createStartPopulation() {
        this.bestPopulation = new ArrayList<>();
        this.currentPopulation = new ArrayList<>();
        IntStream.range(0,4).boxed().forEach(index -> {
            bestPopulation.add(this.createTimeTable().getLessonBlocks());
            currentPopulation.add(cloneLessonBlocks(bestPopulation.get(index)));

        });
    }

    private List<LessonBlock> cloneLessonBlocks(List<LessonBlock> lessonBlocks) {
        List<LessonBlock> newLessonBlocks = new ArrayList<>();
        for(LessonBlock lessonBlock : lessonBlocks) {
            LessonBlock newLessonBlock = new LessonBlock();
            newLessonBlock.setId(lessonBlock.getId());
            newLessonBlock.setDay(Day.valueOf(lessonBlock.getDay().name()));
            newLessonBlock.setLessonNumber(LessonNumber.valueOf(lessonBlock.getLessonNumber().name()));

            Grade newGrade = new Grade();
            newGrade.setId(lessonBlock.getGrade().getId());
            newGrade.setName(lessonBlock.getGrade().getName());
            newLessonBlock.setGrade(newGrade);

            Subject newSubject = new Subject();
            newSubject.setId(lessonBlock.getSubject().getId());
            newSubject.setName(lessonBlock.getSubject().getName());
            newSubject.setRoomTypeNeeded(RoomType.valueOf(lessonBlock.getSubject().getRoomTypeNeeded().name()));
            newLessonBlock.setSubject(newSubject);

            Teacher newTeacher = new Teacher();
            newTeacher.setId(lessonBlock.getTeacher().getId());
            newTeacher.setFirstName(lessonBlock.getTeacher().getFirstName());
            newTeacher.setLastName(lessonBlock.getTeacher().getLastName());
            newTeacher.setSubjects(cloneSubjects(lessonBlock.getTeacher().getSubjects()));
            newLessonBlock.setTeacher(newTeacher);

            Room newRoom = new Room();
            newRoom.setId(lessonBlock.getRoom().getId());
            newRoom.setNumber(lessonBlock.getRoom().getNumber());
            newRoom.setRoomType(RoomType.valueOf(lessonBlock.getRoom().getRoomType().name()));
            newLessonBlock.setRoom(newRoom);

            newLessonBlocks.add(newLessonBlock);
        }
        return newLessonBlocks;
    }

    private List<Subject> cloneSubjects(List<Subject> subjects) {
        List<Subject> newSubjects = new ArrayList<>();
        for(Subject subject : subjects) {
            Subject newSubject = new Subject();
            newSubject.setId(subject.getId());
            newSubject.setName(subject.getName());
            newSubject.setRoomTypeNeeded(RoomType.valueOf(subject.getRoomTypeNeeded().name()));
            newSubjects.add(newSubject);
        }
        return newSubjects;
    }

}
