-- liquibase formatted sql
-- changeset nbelousova:1
create table pet (
id bigint primary key,
name text,
age integer,
withLimitedOpportunities boolean,
typeOfAnimal text,
isAdopted boolean,
)

