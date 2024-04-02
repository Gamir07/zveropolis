-- liquibase formatted sql
-- changeset nbelousova:1
create table cat (
id bigint primary key,
name text,
age integer,
limitedOpportunities boolean
)
-- changeset nbelousova:2
create table dog (
id bigint primary key,
name text,
age integer,
limitedOpportunities boolean
)