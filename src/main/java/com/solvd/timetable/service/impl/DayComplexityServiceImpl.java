package com.solvd.timetable.service.impl;

import com.solvd.timetable.algorithm.DayComplexity;
import com.solvd.timetable.persistence.DayComplexityRepository;
import com.solvd.timetable.persistence.Impl.DayComplexityRepositoryImpl;
import com.solvd.timetable.service.DayComplexityService;

import java.util.List;

public class DayComplexityServiceImpl implements DayComplexityService {

    private final DayComplexityRepository dayComplexityRepository;

    public DayComplexityServiceImpl() {
        this.dayComplexityRepository = new DayComplexityRepositoryImpl();
    }

    @Override
    public List<DayComplexity> getAll() {
        return dayComplexityRepository.getDayComplexities();
    }

}
