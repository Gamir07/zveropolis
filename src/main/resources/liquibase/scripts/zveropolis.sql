-- liquibase formatted sql
-- changeset nbelousova:1
create table cats (
id bigint primary key,
name text,
age integer,
limitedOpportunities boolean
)
-- changeset nbelousova:2
create table dogs (
id bigint primary key,
name text,
age integer,
limitedOpportunities boolean
)