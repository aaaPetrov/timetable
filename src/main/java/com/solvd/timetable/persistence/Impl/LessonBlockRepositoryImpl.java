package com.solvd.timetable.persistence.Impl;

import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.persistence.LessonBlockRepository;
import com.solvd.timetable.persistence.MybatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LessonBlockRepositoryImpl implements LessonBlockRepository {

    @Override
    public List<LessonBlock> getLessonBlocks() {
        List<LessonBlock> lessonBlocks;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            LessonBlockRepository lessonBlockRepository = session.getMapper(LessonBlockRepository.class);
            lessonBlocks = lessonBlockRepository.getLessonBlocks();
        }
        return lessonBlocks;
    }
}
