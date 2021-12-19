package com.solvd.timetable.persistence;

import com.solvd.timetable.domain.curriculum.GradeCurriculum;

import java.util.List;

public interface GradeCurriculumRepository {

    List<GradeCurriculum> getGradeCurricula();

}
