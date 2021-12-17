package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.*;
import com.solvd.timetable.domain.timetable.Day;
import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.domain.timetable.LessonNumber;
import com.solvd.timetable.domain.timetable.TimeTable;
import com.solvd.timetable.persistence.DayComplexityRepository;
import com.solvd.timetable.persistence.Impl.DayComplexityRepositoryImpl;
import com.solvd.timetable.persistence.Impl.SubjectComplexityRepositoryImpl;
import com.solvd.timetable.persistence.SubjectComplexityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Genetic extends Algorithm {

    private List<IndividualMark> bestPopulation;
    private List<IndividualMark> currentPopulation;
    private List<DayComplexity> dayComplexities;
    private List<SubjectComplexity> subjectComplexities;
    private List<SubjectArea> subjectAreas;
    private List<SubjectPosition> subjectPositions;
    private List<TeacherWish> teacherWishes;

    public Genetic(int daysInWeek) {
        super(daysInWeek);
        DayComplexityRepository dayComplexityRepository = new DayComplexityRepositoryImpl();
        this.dayComplexities =  dayComplexityRepository.getDayComplexities();
        formatDayComplexity(this.dayComplexities, daysInWeek);

        SubjectComplexityRepository subjectComplexityRepository = new SubjectComplexityRepositoryImpl();
        this.subjectComplexities = subjectComplexityRepository.getSubjectComplexities();

        /*createStartPopulation();
        this.subjectAreas = null;
        this.bestPopulation = null;
        this.teacherWishes = null;*/
    }

    public TimeTable tryGenetic() {
        long iteration = 0;
        while(iteration < Long.MAX_VALUE) {
            crossBreeding();
            mutation();
            grading();
            iteration++;
        }
        return null;
    }

    private void createStartPopulation() {
        this.bestPopulation = new ArrayList<>();
        this.currentPopulation = new ArrayList<>();
        IntStream.range(0,4).boxed().forEach(index -> {
            IndividualMark individualMark = new IndividualMark();
            individualMark.setIndividual(this.createTimeTable().getLessonBlocks());
            this.bestPopulation.add(individualMark);
        });
    }

    private void crossBreeding() {
        this.currentPopulation = clonePopulation(this.bestPopulation);
        for(int i = 0; i < this.currentPopulation.size(); i+=2) {
            LessonBlock firstIndividualLessonBlock = getRandomLessonBlock(this.currentPopulation.get(i));
            int firstIndex = this.currentPopulation.get(i).getIndividual().indexOf(firstIndividualLessonBlock);

            LessonBlock intermediate = cloneLessonBlock(firstIndividualLessonBlock);

            LessonBlock secondIndividualLessonBlock = getRandomLessonBlock(this.currentPopulation.get(i + 1));
            int secondIndex = this.currentPopulation.get(i + 1).getIndividual().indexOf(secondIndividualLessonBlock);

            this.currentPopulation.get(i).getIndividual().get(firstIndex).setSubject(secondIndividualLessonBlock.getSubject());
            this.currentPopulation.get(i).getIndividual().get(firstIndex).setTeacher(secondIndividualLessonBlock.getTeacher());
            this.currentPopulation.get(i).getIndividual().get(firstIndex).setRoom(secondIndividualLessonBlock.getRoom());

            this.currentPopulation.get(i+1).getIndividual().get(secondIndex).setSubject(intermediate.getSubject());
            this.currentPopulation.get(i+1).getIndividual().get(secondIndex).setTeacher(intermediate.getTeacher());
            this.currentPopulation.get(i+1).getIndividual().get(secondIndex).setRoom(intermediate.getRoom());
        }
    }

    private void mutation() {
        for(IndividualMark individualMark : this.currentPopulation) {
            LessonBlock firstLessonBlock = null;
            LessonBlock secondLessonBlock = null;
            while(true) {
                firstLessonBlock = getRandomLessonBlock(individualMark);
                secondLessonBlock = getRandomLessonBlock(individualMark);
                if(firstLessonBlock != secondLessonBlock) {
                    break;
                }
            }

            LessonBlock intermediate = cloneLessonBlock(firstLessonBlock);

            firstLessonBlock.setSubject(secondLessonBlock.getSubject());
            firstLessonBlock.setTeacher(secondLessonBlock.getTeacher());
            firstLessonBlock.setRoom(secondLessonBlock.getRoom());

            secondLessonBlock.setSubject(intermediate.getSubject());
            secondLessonBlock.setTeacher(intermediate.getTeacher());
            secondLessonBlock.setRoom(intermediate.getRoom());
        }
    }

    private void grading() {
        for(IndividualMark individualMark : this.currentPopulation) {
            int mark = 0;
            List<LessonBlock> lessonBlocks = individualMark.getIndividual();
            mark += gradeForOneTeacherPerLesson(lessonBlocks);
            mark += gradeForOneSubjectPerLesson(lessonBlocks);
            mark += gradeForOneSubjectPerDay(lessonBlocks);
            mark += gradeForOneRoomPerLesson(lessonBlocks);
            mark += gradeDayComplexity(lessonBlocks);

        }
    }

    public int gradeDayComplexity(List<LessonBlock> lessonBlocks) {
        int mark = 0;

        for(int j = 0; j < this.gradesCount; j++) {
            int grade = j * this.maxLessonCount;


            for(int i = 0; i < this.daysInWeek; i++) {
                int day = i * this.gradesCount * this.maxLessonCount;

                int complexity = 0;
                for(int lesson = 0; lesson < this.maxLessonCount; lesson++) {
                    int index = day + grade + lesson;
                    LessonBlock lessonBlock = lessonBlocks.get(index);
                    if(lessonBlock != null) {
                        Subject subject = lessonBlock.getSubject();
                        complexity += this.subjectComplexities.stream()
                                .filter(subjectComplexity -> subjectComplexity.getSubject().getName().equals(subject.getName()))
                                .map(subjectComplexity -> subjectComplexity.getComplexity())
                                .findFirst()
                                .get();
                    }
                }
                Day dayInWeek = days.get(i);
                int complexityLimit = dayComplexities.stream()
                        .filter(dayComplexity -> dayComplexity.getDay().name().equals(dayInWeek.name()))
                        .map(dayComplexity -> dayComplexity.getDayComplexity())
                        .findFirst()
                        .get();
                if(complexity < complexityLimit) {
                    mark += 60;
                } else {
                    mark += 0;
                }
            }
        }
        mark = mark / this.gradesCount;
        return mark;
    }

    private int gradeForOneSubjectPerDay(List<LessonBlock> lessonBlocks) {
        int mark = 0;

        dayLoop:
        for(int i = 0; i < this.daysInWeek; i++) {
            int day = i * this.gradesCount * this.maxLessonCount;

            for(int j = 0; j < this.gradesCount; j++) {
                int grade = j * this.maxLessonCount;

                for(int lesson = 0; lesson < this.maxLessonCount; lesson++) {
                    int index = day + grade + lesson;
                    LessonBlock lessonBlock = lessonBlocks.get(index);
                    if(lessonBlock != null) {
                        Subject subject = lessonBlock.getSubject();

                        for(int searchLesson = lesson + 1; searchLesson < this.maxLessonCount; searchLesson++) {
                            int searchIndex = day + grade + searchLesson;
                            LessonBlock searchLessonBlock = lessonBlocks.get(searchIndex);
                            if(searchLessonBlock != null) {
                                Subject searchSubject = searchLessonBlock.getSubject();
                                if(!subject.getId().equals(searchSubject.getId())) {
                                    mark = 1000;
                                } else {
                                    mark = 0;
                                    break dayLoop;
                                }
                            } else {
                                mark = 1000;
                            }
                        }
                    }
                }
            }
        }
        return mark;
    }

    private int gradeForOneRoomPerLesson(List<LessonBlock> lessonBlocks) {
        int mark = 0;

        dayLoop:
        for(int i = 0; i < this.daysInWeek; i++) {
            int day = i * this.gradesCount * this.maxLessonCount;

            for(int j = 0; j < this.gradesCount; j++) {
                int grade = j * this.maxLessonCount;

                for(int lesson = 0; lesson < this.maxLessonCount; lesson++) {
                    int index = day + grade + lesson;
                    LessonBlock lessonBlock = lessonBlocks.get(index);
                    if(lessonBlock != null) {
                        Room room = lessonBlock.getRoom();

                        for(int x = 0; x < this.gradesCount; x++) {
                            int timeTravellerGrade = x * this.maxLessonCount;
                            if(timeTravellerGrade != grade) {
                                int timeTravellerIndex =  day + timeTravellerGrade + lesson;
                                LessonBlock timeTravellerLessonBlock = lessonBlocks.get(timeTravellerIndex);
                                if (timeTravellerLessonBlock != null) {
                                    Room timeTraveller = timeTravellerLessonBlock.getRoom();
                                    if (!room.getId().equals(timeTraveller.getId())) {
                                        mark = 1000;
                                    } else {
                                        mark = 0;
                                        break dayLoop;
                                    }
                                } else {
                                    mark = 1000;
                                }
                            }
                        }
                    }
                }
            }
        }
        return mark;
    }

    private int gradeForOneSubjectPerLesson(List<LessonBlock> lessonBlocks) {
        int mark = 0;

        dayLoop:
        for(int i = 0; i < this.daysInWeek; i++) {
            int day = i * this.gradesCount * this.maxLessonCount;

            for(int j = 0; j < this.gradesCount; j++) {
                int grade = j * this.maxLessonCount;

                for(int lesson = 0; lesson < this.maxLessonCount; lesson++) {
                    int index = day + grade + lesson;
                    LessonBlock lessonBlock = lessonBlocks.get(index);
                    if(lessonBlock != null) {
                        Subject subject = lessonBlock.getSubject();

                        for(int x = 0; x < this.gradesCount; x++) {
                            int timeTravellerGrade = x * this.maxLessonCount;
                            if(timeTravellerGrade != grade) {
                                int timeTravellerIndex =  day + timeTravellerGrade + lesson;
                                LessonBlock timeTravellerLessonBlock = lessonBlocks.get(timeTravellerIndex);
                                if (timeTravellerLessonBlock != null) {
                                    Subject timeTraveller = timeTravellerLessonBlock.getSubject();
                                    if (!subject.getId().equals(timeTraveller.getId())) {
                                        mark = 1000;
                                    } else {
                                        mark = 0;
                                        break dayLoop;
                                    }
                                } else {
                                    mark = 1000;
                                }
                            }
                        }
                    }
                }
            }
        }
        return mark;
    }

    private int gradeForOneTeacherPerLesson(List<LessonBlock> lessonBlocks) {
        int mark = 0;

        dayLoop:
        for(int i = 0; i < this.daysInWeek; i++) {
            int day = i * this.gradesCount * this.maxLessonCount;

            for(int j = 0; j < this.gradesCount; j++) {
                int grade = j * this.maxLessonCount;

                for(int lesson = 0; lesson < this.maxLessonCount; lesson++) {
                    int index = day + grade + lesson;
                    LessonBlock lessonBlock = lessonBlocks.get(index);
                    if(lessonBlock != null) {
                        Teacher teacher = lessonBlock.getTeacher();

                        for(int x = 0; x < this.gradesCount; x++) {
                            int timeTravellerGrade = x * this.maxLessonCount;
                            if(timeTravellerGrade != grade) {
                                int timeTravellerIndex =  day + timeTravellerGrade + lesson;
                                LessonBlock timeTravellerLessonBlock = lessonBlocks.get(timeTravellerIndex);
                                if (timeTravellerLessonBlock != null) {
                                    Teacher timeTraveller = timeTravellerLessonBlock.getTeacher();
                                    if (!teacher.getId().equals(timeTraveller.getId())) {
                                        mark = 1000;
                                    } else {
                                        mark = 0;
                                        break dayLoop;
                                    }
                                } else {
                                    mark = 1000;
                                }
                            }
                        }
                    }
                }
            }
        }
        return mark;
    }

    private LessonBlock getRandomLessonBlock(IndividualMark individualMark) {
        int range = individualMark.getIndividual().size();
        LessonBlock result = null;
        while (true) {
            int random = (int)(Math.random() * range);
            result = individualMark.getIndividual().get(random);
            if(result != null) {
                break;
            }
        }
        return result;
    }

    private List<IndividualMark> clonePopulation(List<IndividualMark> population) {
        List<IndividualMark> newPopulation = new ArrayList<>();
        for(IndividualMark individualMark : population) {
            List<LessonBlock> newLessonBlocks = cloneLessonBlocks(individualMark.getIndividual());
            IndividualMark newIndividualMark = new IndividualMark();
            newIndividualMark.setIndividual(newLessonBlocks);
            newPopulation.add(newIndividualMark);
        }
        return newPopulation;
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

    private LessonBlock cloneLessonBlock(LessonBlock lessonBlock) {
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

        return newLessonBlock;
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

    private void formatDayComplexity(List<DayComplexity> dayComplexities, int daysInWeek) {
        if(daysInWeek == 5) {
            this.dayComplexities.remove(this.dayComplexities.size()-1);
        } else {
            for(DayComplexity dayComplexity : this.dayComplexities) {
                int complexity = (int)(dayComplexity.getDayComplexity() * 0.833);
                dayComplexity.setDayComplexity(complexity);
            }
        }
    }

}
