create table if not exists owner(
    owner_id bigint primary key,
    owner_first_name varchar(100),
    owner_last_name varchar(200),
    owner_email varchar(200)
);

create sequence owner_seq start with 1 increment by 1;