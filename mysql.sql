create database ahorcado;
use ahorcado;

create table words(
    id_word int auto_increment,
    word varchar(50),
    constraint  pk_id_word primary key (id_word),
    constraint unq_word unique (word)
);

create table winners(
    id_winner int auto_increment,
    name varchar(50),
    win_date date,
    id_word int,
    constraint pk_id_winner primary key (id_winner),
    constraint fk_id_word foreign key (id_word) references words (id_word)
);