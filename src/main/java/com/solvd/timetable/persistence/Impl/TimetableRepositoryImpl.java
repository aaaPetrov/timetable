package com.solvd.timetable.persistence.Impl;

import com.solvd.timetable.domain.timetable.LessonBlock;
import com.solvd.timetable.persistence.MybatisSessionHolder;
import com.solvd.timetable.persistence.TimetableRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class TimetableRepositoryImpl implements TimetableRepository {

    @Override
    public void createTimetable(LessonBlock lessonBlock) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TimetableRepository timetableRepository = session.getMapper(TimetableRepository.class);
            timetableRepository.createTimetable(lessonBlock);
        }
    }

    @Override
    public List<LessonBlock> getLessonBlocks() {
        List<LessonBlock> lessonBlocks;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TimetableRepository timetableRepository = session.getMapper(TimetableRepository.class);
            lessonBlocks = timetableRepository.getLessonBlocks();
        }
        return lessonBlocks;
    }

}
