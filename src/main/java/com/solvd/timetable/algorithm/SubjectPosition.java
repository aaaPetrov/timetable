package com.solvd.timetable.algorithm;

import com.solvd.timetable.domain.Subject;
import com.solvd.timetable.domain.timetable.LessonNumber;

import java.util.List;

public class SubjectPosition {

    private Long id;
    private Subject subject;
    private List<LessonNumber> positions;

    public SubjectPosition() {}

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<LessonNumber> getPositions() {
        return positions;
    }

    public void setPositions(List<LessonNumber> positions) {
        this.positions = positions;
    }

}
