package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.curriculum.GradeCurriculum;
import com.solvd.timetable.persistence.GradeCurriculumRepository;
import com.solvd.timetable.persistence.Impl.GradeCurriculumRepositoryImpl;
import com.solvd.timetable.service.GradeCurriculumService;

import java.util.List;

public class GradeCurriculumServiceImpl implements GradeCurriculumService {

    private final GradeCurriculumRepository gradeCurriculumRepository;

    public GradeCurriculumServiceImpl() {
        this.gradeCurriculumRepository = new GradeCurriculumRepositoryImpl();
    }

    @Override
    public List<GradeCurriculum> getAll() {
        return gradeCurriculumRepository.getGradeCurricula();
    }

}
