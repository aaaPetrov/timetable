package com.solvd.timetable.persistence.Impl;

import com.solvd.timetable.algorithm.SubjectPosition;
import com.solvd.timetable.persistence.MybatisSessionHolder;
import com.solvd.timetable.persistence.SubjectPositionRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubjectPositionsRepositoryImpl implements SubjectPositionRepository {

    @Override
    public List<SubjectPosition> getSubjectPositions() {
        List<SubjectPosition> subjectPositions;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            SubjectPositionRepository subjectPositionRepository = session.getMapper(SubjectPositionRepository.class);
            subjectPositions = subjectPositionRepository.getSubjectPositions();
        }
        return subjectPositions;
    }

}
