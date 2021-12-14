use timetabledb;
select * from classes;
select * from days;
select * from teachers;
select * from subjects;
select * from lesson_numbers;
select * from classrooms;
select t.id, t.first_name, t.last_name, ts.id, s.id, s.name, s.room_type_needed 
from teachers t left join teacher_subjects ts on t.id = ts.teacher_id left join subjects s on s.id = ts.subject_id;
select s.id, s.name, sw.count from subjects s left join subject_per_week sw on  sw.subject_id = s.id;