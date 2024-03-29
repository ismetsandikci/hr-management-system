-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.users
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email_address character varying(320) NOT NULL,
    password character varying(25) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE public.candidates
(
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    nationality_id character(11) NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT pk_candidates PRIMARY KEY (user_id),
	CONSTRAINT fk_candidates_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE,
	CONSTRAINT uc_candidates_nationality_id UNIQUE (nationality_id)
);

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(150) NOT NULL,
    web_address character varying(75) NOT NULL,
    CONSTRAINT pk_employers PRIMARY KEY (user_id),
	CONSTRAINT fk_employers_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE
);

CREATE TABLE public.employer_phones(
	id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	employer_id integer NOT NULL,
	phone_number character varying(12) NOT NULL,
	CONSTRAINT pk_employer_phones PRIMARY KEY (id),
	CONSTRAINT fk_employer_phones_employer_id FOREIGN KEY (employer_id) REFERENCES public.employers (user_id) ON DELETE CASCADE
);

CREATE TABLE public.employees
(
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
	CONSTRAINT pk_employees PRIMARY KEY (user_id),
	CONSTRAINT fk_employees_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE
);

CREATE TABLE public.verification_codes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
	verification_code character varying(50) NOT NULL,
	created_date date NOT NULL,
	expired_date date NOT NULL,
    verification_date date NOT NULL,
    is_verified boolean NOT NULL,
    CONSTRAINT pk_verification_codes PRIMARY KEY (id),
	CONSTRAINT fk_verification_codes_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE
);

CREATE TABLE public.employee_confirms(
	id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	employee_id integer NOT NULL,
	is_confirmed boolean DEFAULT false NOT NULL,
	confirm_date date NOT NULL,
	CONSTRAINT pk_employee_confirms PRIMARY KEY (id),
	CONSTRAINT fk_employee_confirms_employees FOREIGN KEY (employee_id) REFERENCES public.employees (user_id) ON DELETE CASCADE
);

CREATE TABLE public.employee_confirms_employers(
	id integer NOT NULL,
	employer_id integer NOT NULL,
	CONSTRAINT pk_employee_confirms_employers PRIMARY KEY (id),
	CONSTRAINT fk_employee_confirms_employers_employee_confirms FOREIGN KEY (id) REFERENCES public.employee_confirms (id) ON DELETE CASCADE,
	CONSTRAINT fk_employee_confirms_employers_employers FOREIGN KEY (employer_id) REFERENCES public.employers (user_id) ON DELETE CASCADE
);

CREATE TABLE public.job_positions(
	id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	name character varying(255) NOT NULL,
	CONSTRAINT pk_job_titles PRIMARY KEY (id),
	CONSTRAINT uc_job_titles_title UNIQUE (name)
);

CREATE TABLE public.resumes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	candidate_id integer NOT NULL,
    image character varying(250) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resumes PRIMARY KEY (id),
	CONSTRAINT fk_resumes_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates (user_id) ON DELETE CASCADE
);

CREATE TABLE public.resume_educations
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    school_name character varying(150) NOT NULL,
    department_name character varying(150) NOT NULL,
    start_date date NOT NULL,
    graduation_date date,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resume_educations PRIMARY KEY (id),
	CONSTRAINT fk_resume_educations_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);


CREATE TABLE public.resume_job_experiences
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    job_positions_id integer NOT NULL,
    company_name character varying(150) NOT NULL,
    start_date date NOT NULL,
    finish_date date,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resume_job_experiences PRIMARY KEY (id),
	CONSTRAINT fk_resume_job_experiences_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE,
	CONSTRAINT fk_resume_job_experiences_job_positions FOREIGN KEY (job_positions_id) REFERENCES public.job_positions (id) ON DELETE CASCADE
);


CREATE TABLE public.resume_languages
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    language_id integer NOT NULL,
    level character varying(2) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resume_languages PRIMARY KEY (id),
	CONSTRAINT fk_resume_languages_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE,
	CONSTRAINT fk_resume_languages_languages FOREIGN KEY (language_id) REFERENCES public.languages (id) ON DELETE CASCADE
);


CREATE TABLE public.resume_skills
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    name character varying(150) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resume_skills PRIMARY KEY (id),
	CONSTRAINT fk_resume_skills_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);


CREATE TABLE public.resume_cover_letters
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    title character varying(50) NOT NULL,
    coverLetter character varying(250) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resume_cover_letters PRIMARY KEY (id),
	CONSTRAINT fk_resume_cover_letters_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);


CREATE TABLE public.resume_links
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    link_name character varying(50) NOT NULL,
    link_url character varying(150) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_resume_links PRIMARY KEY (id),
	CONSTRAINT fk_resume_links_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);


CREATE TABLE public.languages
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    language_name character varying(50) NOT NULL,
    is_active boolean NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_languages PRIMARY KEY (id)
);

END;