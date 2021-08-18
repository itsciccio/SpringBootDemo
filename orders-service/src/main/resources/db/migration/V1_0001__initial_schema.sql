create table `user_order` (
    id varchar(255) NOT NULL,
    person_id varchar(255),
    total_price float not null,
    primary key (id)
);