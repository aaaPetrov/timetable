package com.solvd.timetable.service.impl;

import com.solvd.timetable.domain.Subject;
import com.solvd.timetable.persistence.Impl.SubjectRepositoryImpl;
import com.solvd.timetable.persistence.SubjectRepository;
import com.solvd.timetable.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl() {
        this.subjectRepository = new SubjectRepositoryImpl();
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.getSubjects();
    }
}
