--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.5.0

-- Started on 2016-01-12 00:55:15 GMT

--SET statement_timeout = 0;
--SET lock_timeout = 0;
--SET client_encoding = 'UTF8';
--SET standard_conforming_strings = on;
--SET check_function_bodies = false;
--SET client_min_messages = warning;
--SET row_security = off;

--
-- TOC entry 179 (class 3079 OID 12749)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 179
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

-- COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


-- SET search_path = public, pg_catalog;

--
-- TOC entry 178 (class 1259 OID 2218972)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


-- ALTER TABLE hibernate_sequence OWNER TO ndsfwczvejnnqi;

-- SET default_tablespace = '';

-- SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 2218913)
-- Name: news_item; Type: TABLE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE TABLE news_item (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    image_url character varying(255),
    link character varying(255),
    summary character varying(255),
    tag character varying(255),
    title character varying(255)
);


--
-- TOC entry 173 (class 1259 OID 2218921)
-- Name: player; Type: TABLE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE TABLE player (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    current_handicap integer NOT NULL,
    first_name character varying(255),
    surname character varying(255)
);


--
-- TOC entry 174 (class 1259 OID 2218929)
-- Name: race_to_ciao_bella; Type: TABLE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE TABLE race_to_ciao_bella (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    season integer NOT NULL
);


--
-- TOC entry 175 (class 1259 OID 2218934)
-- Name: result; Type: TABLE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE TABLE result (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    handicap integer NOT NULL,
    score integer NOT NULL,
    player_id bigint,
    tournament_id bigint
);


--
-- TOC entry 176 (class 1259 OID 2218939)
-- Name: tournament; Type: TABLE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE TABLE tournament (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    date timestamp without time zone,
    name character varying(255),
    race_to_ciao_bella_id bigint,
    venue_id bigint
);


--
-- TOC entry 177 (class 1259 OID 2218944)
-- Name: venue; Type: TABLE; Schema: public; Owner: ndsfwczvejnnqi
--

CREATE TABLE venue (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    google_map_link character varying(255),
    image_url character varying(255),
    link character varying(255),
    name character varying(255)
);


--
-- TOC entry 2797 (class 2606 OID 2218920)
-- Name: news_item_pkey; Type: CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY news_item
    ADD CONSTRAINT news_item_pkey PRIMARY KEY (id);


--
-- TOC entry 2799 (class 2606 OID 2218928)
-- Name: player_pkey; Type: CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY player
    ADD CONSTRAINT player_pkey PRIMARY KEY (id);


--
-- TOC entry 2801 (class 2606 OID 2218933)
-- Name: race_to_ciao_bella_pkey; Type: CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY race_to_ciao_bella
    ADD CONSTRAINT race_to_ciao_bella_pkey PRIMARY KEY (id);


--
-- TOC entry 2803 (class 2606 OID 2218938)
-- Name: result_pkey; Type: CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY result
    ADD CONSTRAINT result_pkey PRIMARY KEY (id);


--
-- TOC entry 2805 (class 2606 OID 2218943)
-- Name: tournament_pkey; Type: CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY tournament
    ADD CONSTRAINT tournament_pkey PRIMARY KEY (id);


--
-- TOC entry 2807 (class 2606 OID 2218951)
-- Name: venue_pkey; Type: CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY venue
    ADD CONSTRAINT venue_pkey PRIMARY KEY (id);


--
-- TOC entry 2810 (class 2606 OID 2218962)
-- Name: fk_6qrx1r0e9ckwk5wgk48pen61o; Type: FK CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY tournament
    ADD CONSTRAINT fk_6qrx1r0e9ckwk5wgk48pen61o FOREIGN KEY (race_to_ciao_bella_id) REFERENCES race_to_ciao_bella(id);


--
-- TOC entry 2809 (class 2606 OID 2218957)
-- Name: fk_ex3sq5mqo01hfs9yfnyn7dv4c; Type: FK CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY result
    ADD CONSTRAINT fk_ex3sq5mqo01hfs9yfnyn7dv4c FOREIGN KEY (tournament_id) REFERENCES tournament(id);


--
-- TOC entry 2808 (class 2606 OID 2218952)
-- Name: fk_gafn70ioalgac95sc3fpfgovm; Type: FK CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY result
    ADD CONSTRAINT fk_gafn70ioalgac95sc3fpfgovm FOREIGN KEY (player_id) REFERENCES player(id);


--
-- TOC entry 2811 (class 2606 OID 2218967)
-- Name: fk_kv3xogav1d7lxj9ovjmk7s3j0; Type: FK CONSTRAINT; Schema: public; Owner: ndsfwczvejnnqi
--

ALTER TABLE ONLY tournament
    ADD CONSTRAINT fk_kv3xogav1d7lxj9ovjmk7s3j0 FOREIGN KEY (venue_id) REFERENCES venue(id);


-- Completed on 2016-01-12 00:55:31 GMT

--
-- PostgreSQL database dump complete
--

