CREATE USER 'user1'@'localhost' IDENTIFIED BY 'pass';
CREATE DATABASE example_db;
GRANT ALL PRIVILEGES ON example_db.* to 'user1'@'localhost';