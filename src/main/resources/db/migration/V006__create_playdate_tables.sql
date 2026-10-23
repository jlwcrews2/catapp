create table if not exists playdate(
    playdate_id bigint primary key,
    playdate_location text,
    playdate_date timestamp
);

create sequence playdate_seq start with 1 increment 1;

create table if not exists cat_playdate(
    playdate_id bigint,
    cat_id bigint
);