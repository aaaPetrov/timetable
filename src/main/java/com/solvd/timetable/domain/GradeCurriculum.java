package com.solvd.timetable.domain;

import java.util.List;

public class GradeCurriculum {

    private Grade grade;
    private List<SubjectCount> countSubjects;

    public GradeCurriculum() {
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<SubjectCount> getCountSubjects() {
        return countSubjects;
    }

    public void setCountSubjects(List<SubjectCount> countSubjects) {
        this.countSubjects = countSubjects;
    }

}
