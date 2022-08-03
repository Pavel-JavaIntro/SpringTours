create table bookings
(
	id serial
		constraint bookings_pkey
			primary key,
	tourist_id integer not null
		constraint booking_tourist_fk
			references users,
	tour_id integer not null
		constraint booking_tour_fk
			references tours,
	paid boolean default false not null
);

alter table bookings owner to postgres;

