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
 ('25', 'MAP'),
 ('37', 'MAP'),
 ('26', 'ALL'),
 ('39', 'ALL'),
 ('35', 'ALL'),
 ('30', 'COMPUTER'),
 ('33', 'LAB'),
 ('32', 'LAB'),
 ('38', 'LAB'),
 ('28', 'ALL'),
 ('13', 'GYM');
 
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
('Marina', 'Sergeevna'),
('Natalia', 'Vasilevna'),
('Natalia', 'Nikolaevna'),
('Alexandra', 'Sergeevna'),
('Elena', 'Igorevna'),
('Uriy', 'Vladimirovich'),
('Vladimir', 'Vladimirovich'),
('Vera', 'Prokopfievna'),
('Pesenka', 'Pesenkova'),
('Kartina', 'Kartinovna'),
('Nepomny', 'Kakzvatevich'),
('Evgeniy', 'Jakovlevich');

insert into teacher_subjects (subject_id, teacher_id) values
(1,3),(2,3), (3,4), (4,5), (5,5), (6,6), (7,7), (8,8), (9,7),
(10,2), (11,1), (12,1), (13,9), (14,12), (15,11), (16,10);

insert into subject_per_week (class_id, subject_id, count) values
(1,1,3),  (1,2,2), (1,3,3), (1,4,3), (1,5,2),
(1,6,2), (1,7,2), (1,9,2), (1,10,2), (1,11,2),
(1,12,1), (1,13,1), (1,14,3), (1,16,1),

(2,1,3),  (2,2,2), (2,3,3), (2,4,3), (2,5,2),
(2,6,2), (2,7,2), (2,9,2), (2,10,2), (2,11,2),
(2,12,1), (2,13,1), (2,14,3), (2,16,1),  

(3,1,3),  (3,2,2),  (3,3,3),  (3,4,3),  (3,5,2),
(3,6,2),  (3,7,2),  (3,8,2),  (3,9,2),  (3,10,2),
(3,11,2),  (3,12,1),  (3,13,1),  (3,14,3),  (3,15,1), 

(4,1,3),  (4,2,2),  (4,3,3),  (4,4,3),  (4,5,2),
(4,6,2),  (4,7,2),  (4,8,2),  (4,9,2),  (4,10,2),
(4,11,2),  (4,12,1),  (4,13,1),  (4,14,3),  (4,15,1);