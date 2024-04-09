--liquibase formatted sql

--changeset kuznetsovanaya:create_users
create table users
(
    chat_id      bigint primary key,
    first_name   varchar(255),
    username     varchar(255),
    phone_number varchar(12),
    is_volunteer boolean default false
);

--changeset kuznetsovanaya:create_pet
create table pet
(
    id                         bigserial primary key,
    name                       varchar(255),
    age                        int,
    with_limited_opportunities boolean,
    type_of_animal             varchar(255),
    user_id                    bigint,
    foreign key (user_id) references users (chat_id)
);

--changeset kuznetsovanaya:alter_table_users
alter table users
    (
    add column pet_id bigint,
    add constraint pet_p foreign key (pet_id) references pet (id)
    );

--changeset kuznetsovanaya:create_photo
create table photo
(
    id         bigserial primary key,
    file_size  bigint,
    media_type text,
    data       bytea
);

--changeset kuznetsovanaya:create_report
create table report
(
    id                   bigserial primary key,
    diet                 text,
    health_and_addiction text,
    behavior             text,
    photo_id             bigint,
    foreign key (photo_id) references photo (id),
    user_id              bigint not null,
    foreign key (user_id) references users (chat_id),
    pet_id               bigint,
    foreign key (pet_id) references pet (id)
);

-- --changeset kuznetsovanaya:create_shelter
create table shelter
(
    id                                      bigserial primary key,
    info                                    text,
    dating_rules                            text,
    adoption_documents                      text,
    transportation_recommendations          text,
    recommendations_arranging_baby          text,
    recommendations_arranging_adult         text,
    recommendations_arranging_with_features text,
    type_of_animal                          varchar(255)
);

