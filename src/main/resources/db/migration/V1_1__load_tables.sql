create sequence news_item_seq;
create table news_item (id bigint NOT NULL DEFAULT nextval('news_item_seq'), created_date timestamp, last_modified_date timestamp, image_url varchar(255), link varchar(255), summary varchar(255), tag varchar(255), title varchar(255), primary key (id));
alter sequence news_item_seq owned by news_item.id;

create sequence player_seq;
create table player (id bigint NOT NULL DEFAULT nextval('player_seq'), created_date timestamp, last_modified_date timestamp, current_handicap integer not null, first_name varchar(255), surname varchar(255), primary key (id));
alter sequence player_seq owned by player.id;

create sequence race_to_ciao_bella_seq;
create table race_to_ciao_bella (id bigint NOT NULL DEFAULT nextval('race_to_ciao_bella_seq'), created_date timestamp, last_modified_date timestamp, season integer not null, primary key (id));
alter sequence race_to_ciao_bella_seq owned by race_to_ciao_bella.id;

create sequence result_seq;
create table result (id bigint NOT NULL DEFAULT nextval('result_seq'), created_date timestamp, last_modified_date timestamp, handicap integer not null, score integer not null, player_id bigint, tournament_id bigint, primary key (id));
alter sequence result_seq owned by result.id;

create sequence tournament_seq;
create table tournament (id bigint NOT NULL DEFAULT nextval('tournament_seq'), created_date timestamp, last_modified_date timestamp, date timestamp, name varchar(255), race_to_ciao_bella_id bigint, venue_id bigint, primary key (id));
alter sequence tournament_seq owned by tournament.id;

create sequence venue_seq;
create table venue (id bigint NOT NULL DEFAULT nextval('venue_seq'), created_date timestamp, last_modified_date timestamp, google_map_link varchar(255), image_url varchar(255), link varchar(255), name varchar(255), primary key (id));
alter sequence venue_seq owned by venue.id;

alter table result add constraint FK_gafn70ioalgac95sc3fpfgovm foreign key (player_id) references player;
alter table result add constraint FK_ex3sq5mqo01hfs9yfnyn7dv4c foreign key (tournament_id) references tournament;
alter table tournament add constraint FK_6qrx1r0e9ckwk5wgk48pen61o foreign key (race_to_ciao_bella_id) references race_to_ciao_bella;
alter table tournament add constraint FK_kv3xogav1d7lxj9ovjmk7s3j0 foreign key (venue_id) references venue;