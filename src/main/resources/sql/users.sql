create table users
(
	id serial
		constraint users_pkey
			primary key,
	name varchar(20) not null,
	surname varchar(30) not null,
	email varchar(40),
	username varchar(30) not null
		constraint user_unique
			unique
		constraint us_fk
			references authorities (username),
	password varchar(100) not null,
	enabled smallint default 1 not null
);

alter table users owner to postgres;

