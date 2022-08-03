create table tour_types
(
	id serial
		constraint tour_types_pkey
			primary key,
	type varchar(25) not null
		constraint type_unique
			unique
);

alter table tour_types owner to postgres;

