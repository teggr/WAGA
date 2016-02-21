CREATE TABLE historic_handicap (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    expired_date timestamp without time zone,
    handicap integer NOT NULL,
    player_id bigint
);

ALTER TABLE ONLY historic_handicap
    ADD CONSTRAINT historic_handicap_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY historic_handicap
    ADD CONSTRAINT sd9f87g6sfd89g76s89df7 FOREIGN KEY (player_id) REFERENCES player(id);

ALTER TABLE player ADD handicap_date timestamp without time zone; 
    
UPDATE player SET handicap_date=created_date;