create table Message
(
id bigint PRIMARY KEY,
text varchar(255)
);

CREATE SEQUENCE hibernate_sequence
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;
ALTER SEQUENCE hibernate_sequence OWNED BY message.id;

ALTER TABLE ONLY message ALTER COLUMN id SET DEFAULT nextval('hibernate_sequence'::regclass);

