-- liquibase formatted sql

-- changeset ggainullin:1

create table sheltercat(
	id bigserial primary key,
	information varchar(256),
	address varchar(50),
	roadmap bytea
);