package com.solvd.timetable.domain;

import java.util.List;

public class TeacherSubject {

    private Teacher teacher;
    private List<Subject> subjects;

    public TeacherSubject() {}

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
