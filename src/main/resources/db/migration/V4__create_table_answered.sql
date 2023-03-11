create table tbl_answered
(
    id         bigint       not null auto_increment,
    message    varchar(300) not null,
    created_at datetime,
    topic_id   bigint       not null,
    author_id  bigint       not null,
    solution   tinyint,
    primary key (id),

    constraint fk_answered_topic_id foreign key (topic_id) references tbl_topic (id),
    constraint fk_answered_author_id foreign key (author_id) references tbl_author (id)
);
