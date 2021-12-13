package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.SubjectCount;
import com.solvd.timetable.persistence.Impl.SubjectCountRepositoryImpl;
import com.solvd.timetable.persistence.SubjectCountRepository;
import com.solvd.timetable.service.SubjectCountService;

import java.util.List;

public class SubjectCountServiceImpl implements SubjectCountService {

    private final SubjectCountRepository subjectCountRepository;

    public SubjectCountServiceImpl() {
        this.subjectCountRepository = new SubjectCountRepositoryImpl();
    }

    @Override
    public List<SubjectCount> getAll() {
        return subjectCountRepository.getSubjectCounts();
    }
}
