package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.Grade;
import com.solvd.timetable.persistence.GradeRepository;
import com.solvd.timetable.persistence.Impl.GradeRepositoryImpl;
import com.solvd.timetable.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl() {
        this.gradeRepository = new GradeRepositoryImpl();
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepository.getGrades();
    }
}
