package com.solvd.timetable.persistence.Impl;

import com.solvd.timetable.domain.Subject;
import com.solvd.timetable.persistence.MybatisSessionHolder;
import com.solvd.timetable.persistence.SubjectRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository {

    @Override
    public List<Subject> getSubjects() {
        List<Subject> subjects;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            SubjectRepository subjectRepository = session.getMapper(SubjectRepository.class);
            subjects = subjectRepository.getSubjects();
        }
        return subjects;
    }
}
