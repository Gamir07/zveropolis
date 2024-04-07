-- liquibase formatted sql

-- changeset ggainullin:1

create table petReport(
	id bigserial primary key,
	dailyPhotoReport bytea,
	generalCondition varchar(50),
	behaviorChanges varchar(50),
	filePath varchar(50),
	mediaType varchar(50),
	fileSize bigserial,
	dateOfReport date,
	pet_id references Pet (id)
);