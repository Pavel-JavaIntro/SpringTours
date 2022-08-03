create sequence authority_id_seq
	as integer;

alter sequence authority_id_seq owner to postgres;

alter sequence authority_id_seq owned by authorities.id;

