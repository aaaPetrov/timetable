package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.Subject;

import java.util.List;

public class SubjectArea {

    private Long id;
    private String areaName;
    private List<Subject> subjects;

    public SubjectArea() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
