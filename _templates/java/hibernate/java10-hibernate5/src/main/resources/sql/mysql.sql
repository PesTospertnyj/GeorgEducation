drop database if exists jpwh;
-- drop user if exists jpwh;
drop user jpwh;
CREATE DATABASE IF NOT EXISTS jpwh;
-- create user IF NOT EXISTS jpwh identified by 'jpwh';
create user jpwh identified by 'jpwh';
grant all privileges on jpwh.* to jpwh;

CREATE  TABLE jpwh.message (
student_id INT NOT NULL ,
student_name VARCHAR(45) NOT NULL ,
student_age INT NOT NULL ,
PRIMARY KEY (student_id) );