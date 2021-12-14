use timetabledb;

insert into days (name) values 
('MONDAY'),
('TUESDAY'),
('WEDNESDAY'),
('THURSDAY'),
('FRIDAY'),
('SATURDAY');

 insert into lesson_numbers (time_name) values
 ('FIRST'),
 ('SECOND'),
 ('THIRD'),
 ('FOURTH'),
 ('FIFTH'),
 ('SIXTH'),
 ('SEVENTH');
 
 insert into classrooms (number, type) values
 ('1', 'LAB'),
 ('2', 'GYM'),
 ('3', 'MAP'),
 ('4', 'ALL'),
 ('5', 'ALL'),
 ('6', 'ALL'),
 ('7', 'ALL'),
 ('8', 'LAB'),
 ('9', 'ALL'),
 ('10', 'COMPUTER'),
 ('11', 'MAP');
 
insert into classes (name) values
('7A'),
('7B'),
('8A'),
('8B');

insert into subjects (name, room_type_needed) values
('Russian Language', 'ALL'),
('Russian Literature', 'ALL'),
('English Language', 'ALL'),
('Algebra', 'ALL'),
('Geometry', 'ALL'),
('Informatics', 'COMPUTER'),
('Chemistry', 'LAB'),
('Biology', 'LAB'),
('Physics', 'LAB'),
('Geography', 'MAP'),
('History', 'MAP'),
('Social Science', 'ALL'),
('Music', 'ALL'),
('Physical Culture', 'GYM'),
('O.B.G.', 'ALL'),
('Art', 'ALL');

insert into teachers (first_name,last_name) values
('Elena', 'Ivanovna'),
('Ivan', 'Petrovich'),
('Ilia', 'Mihalych'),
('Olga', 'Alexandrovna'),
('Svetlana', 'Nikolaevna'),
('Tatiana', 'Olegovna'),
('Yana', 'Vitalievna'),
('Katerina', 'Sergeevna'),
('Dmitry', 'Dmitrievich'),
('Uriy', 'Vladimirovich'),
('Evgeniy', 'Jakovlevich'),
('Marina', 'Sergeevna');


insert into teacher_subjects (subject_id, teacher_id) values
(1,1),
(2,1),
(3,2),
(4,3),
(5,3),
(6,10),
(7,4),
(8,5),
(9,6),
(10,12),
(11,12),
(12,7),
(13,8),
(14,11),
(15,7),
(16,9);


insert into subject_per_week (class_id, subject_id, count) values
(1,1,3),  (1,2,2),  (1,3,3),  (1,4,3),  (1,5,2),
(1,6,2),  (1,8,2),  (1,9,2),  (1,10,2), (1,11,1),
(1,12,1),  (1,13,1),  (1,14,3),  (1,16,1),

 (2,1,3),  (2,2,2),  (2,3,3),  (2,4,3),  (2,5,2),
(2,6,2),   (2,8,2),  (2,9,2),  (2,10,2), (2,11,2),
(2,12,1),  (2,13,1),  (2,14,3),  (2,16,1),  

(3,1,3),  (3,2,2),  (3,3,3),  (3,4,3),  (3,5,2),
(3,6,2),  (3,7,2),  (3,8,2),  (3,9,2),  (3,10,2),
(3,11,2),  (3,12,1),  (3,13,1),  (3,14,3),  (3,15,1), 

 (4,1,3),  (4,2,2),  (4,3,3),  (4,4,3),  (4,5,2),
(4,6,2),  (4,7,2),  (4,8,2),  (4,9,2),  (4,10,2),
(4,11,2),  (4,12,1),  (4,13,1),  (4,14,3),  (4,15,1);

