package com.solvd.timetable.persistence.Impl;

import com.solvd.timetable.domain.GradeCurriculum;
import com.solvd.timetable.persistence.GradeCurriculumRepository;
import com.solvd.timetable.persistence.MybatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GradeCurriculumRepositoryImpl implements GradeCurriculumRepository {

    @Override
    public List<GradeCurriculum> getGradeCurricula() {
        List<GradeCurriculum> gradeCurricula;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            GradeCurriculumRepository gradeCurriculumRepository = session.getMapper(GradeCurriculumRepository.class);
            gradeCurricula = gradeCurriculumRepository.getGradeCurricula();
        }
        return gradeCurricula;
    }
}
