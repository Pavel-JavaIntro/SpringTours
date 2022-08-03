create table authorities
(
	id integer default nextval('authority_id_seq'::regclass) not null
		constraint authority_pkey
			primary key,
	username varchar(30) not null
		constraint us_unique
			unique,
	authority varchar(30) default 'ROLE_TOURIST'::character varying not null
);

alter table authorities owner to postgres;

