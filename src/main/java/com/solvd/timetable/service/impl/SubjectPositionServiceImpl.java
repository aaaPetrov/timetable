package com.solvd.timetable.service.impl;

import com.solvd.timetable.algorithm.SubjectPosition;
import com.solvd.timetable.persistence.Impl.SubjectPositionsRepositoryImpl;
import com.solvd.timetable.persistence.SubjectPositionRepository;
import com.solvd.timetable.service.SubjectPositionService;

import java.util.List;

public class SubjectPositionServiceImpl implements SubjectPositionService {

    private final SubjectPositionRepository subjectPositionRepository;

    public SubjectPositionServiceImpl() {
        this.subjectPositionRepository = new SubjectPositionsRepositoryImpl();
    }

    @Override
    public List<SubjectPosition> getAll() {
        return subjectPositionRepository.getSubjectPositions();
    }
}
