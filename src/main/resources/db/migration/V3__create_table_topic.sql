create table tbl_topic
(
    id         bigint       not null auto_increment,
    title      varchar(100) not null,
    message    varchar(300) not null,
    created_at datetime,
    status     varchar(100),
    course_id  bigint       not null,
    author_id  bigint       not null,
    primary key (id),

    constraint fk_course_id foreign key (course_id) references tbl_course (id),
    constraint fk_author_id foreign key (author_id) references tbl_author (id)

);
