-- liquibase formatted sql

-- changeset ggainullin:1

create table cat(
	id bigserial primary key,
	name varchar(50),
	age integer,
	is_handicapped boolean
);