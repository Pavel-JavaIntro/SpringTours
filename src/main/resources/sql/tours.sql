create table tours
(
	id serial
		constraint tours_pkey
			primary key,
	description varchar(100) default 'some'::character varying not null,
	capacity integer not null,
	start_date date not null,
	end_date date not null,
	price money not null,
	booked integer not null,
	type_id integer not null
		constraint tour_type_fk
			references tour_types,
	tour_status varchar(20) default 'VALID'::character varying not null
);

alter table tours owner to postgres;

