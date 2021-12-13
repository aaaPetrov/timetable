package com.solvd.timetable.persistence.Impl;

import com.solvd.timetable.domain.SubjectCount;
import com.solvd.timetable.persistence.MybatisSessionHolder;
import com.solvd.timetable.persistence.SubjectCountRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubjectCountRepositoryImpl implements SubjectCountRepository {

    @Override
    public List<SubjectCount> getSubjectCounts() {
        List<SubjectCount> subjectCounts;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            SubjectCountRepository subjectCountRepository = session.getMapper(SubjectCountRepository.class);
            subjectCounts = subjectCountRepository.getSubjectCounts();
        }
        return subjectCounts;
    }
}
