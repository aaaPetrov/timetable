package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.Subject;
import com.solvd.timetable.domain.Teacher;

public class TeacherSubject {

    private Teacher teacher;
    private Subject subject;

    public TeacherSubject() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
