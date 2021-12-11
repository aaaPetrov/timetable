drop database if exists timetabledb;

create database if not exists timetabledb;
use timetabledb;

create table if not exists days(
id serial,
name varchar(10) not null,
primary key(id)
);

create table if not exists lesson_numbers (
id serial,
time_name varchar(45) not null,
primary key(id)
);

create table if not exists classrooms (
id serial,
number varchar(3) not null,
type varchar(20) not null,
primary key(id)
);

create table if not exists classes (
id serial,
name varchar(3) not null,
primary key(id)
);

create table if not exists teachers (
id serial,
first_name varchar(20) not null,
last_name varchar(20) not null,
primary key(id)
);


create table if not exists subjects (
id serial,
name varchar(50) not null,
room_type_needed varchar(20) not null,
primary key(id)
);


create table if not exists teacher_subjects (
id serial,
subject_id  bigint unsigned not null,
teacher_id  bigint unsigned not null,
primary key(id),
constraint fk_teacher_subjects_subject_id foreign key (subject_id) references subjects(id) 
on update no action 
on delete cascade,
constraint fk_teacher_subjects_teacher_id foreign key (teacher_id) references teachers(id) 
on update no action 
on delete cascade
);


create table if not exists subject_per_week (
id serial,
class_id  bigint unsigned not null,
subject_id  bigint unsigned not null,
count  int unsigned not null,
primary key(id),
constraint fk_subject_per_week_class_id foreign key (class_id) references classes(id) 
on update no action 
on delete cascade,
constraint fk_subject_per_week_subject_id foreign key (subject_id) references subjects(id) 
on update no action 
on delete cascade
);

create table if not exists timetable (
id serial,
days_id  bigint unsigned not null,
lesson_numbers_id  bigint unsigned not null,
classes_id  bigint unsigned not null,
subjects_id  bigint unsigned not null,
classrooms_id  bigint unsigned not null,
teachers_id  bigint unsigned not null,
primary key(id),
constraint fk_timetable_days_id foreign key (days_id) references days(id) 
on update no action 
on delete cascade,
constraint fk_timetable_lesson_numbers_id foreign key (lesson_numbers_id) references lesson_numbers(id) 
on update no action 
on delete cascade,
constraint fk_timetable_classes_id foreign key (classes_id) references classes(id) 
on update no action 
on delete cascade,
constraint fk_timetable_lesson_subjects_id foreign key (subjects_id) references subjects(id) 
on update no action 
on delete cascade,
constraint fk_timetable_classrooms_id foreign key (classrooms_id) references classrooms(id) 
on update no action 
on delete cascade,
constraint fk_timetable_lesson_teachers_id foreign key (teachers_id) references teachers(id) 
on update no action 
on delete cascade
);



