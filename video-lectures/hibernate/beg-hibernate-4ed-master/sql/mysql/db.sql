CREATE USER 'user1'@'localhost' IDENTIFIED BY 'pass';
CREATE DATABASE hiber1;
GRANT ALL PRIVILEGES ON hiber1.* to 'user1'@'localhost';