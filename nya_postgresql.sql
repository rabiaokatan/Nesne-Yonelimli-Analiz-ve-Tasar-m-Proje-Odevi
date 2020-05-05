--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: giris(character varying, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.giris(username_ character varying, password_ character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
if(SELECT COUNT(*) FROM "Kullanici" WHERE "KullaniciAdi"=username_ and Sifre=password_)>0 THEN
    RETURN 1;
ELSE
    RETURN 0;
    END IF;
END
$$;


ALTER FUNCTION public.giris(username_ character varying, password_ character varying) OWNER TO postgres;

SET default_tablespace = '';

--
-- Name: Kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Kullanici" (
    "KullaniciAdi" character varying(2044),
    "Sifre" character varying(2044)
);


ALTER TABLE public."Kullanici" OWNER TO postgres;

--
-- Data for Name: Kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Kullanici" VALUES ('Rabia1', 'deneme1');
INSERT INTO public."Kullanici" VALUES ('Kullanici2', 'deneme2');


--
-- Name: Kullanici unique_Kullanici_KullaniciAdi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "unique_Kullanici_KullaniciAdi" UNIQUE ("KullaniciAdi");


--
-- Name: Kullanici unique_Kullanici_Sifre; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "unique_Kullanici_Sifre" UNIQUE ("Sifre");


--
-- PostgreSQL database dump complete
--

