SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'hiber1' -- ← change this to your DB
  AND pid <> pg_backend_pid();

drop database hiber1;
drop user user1;

CREATE DATABASE hiber1;
CREATE USER user1 WITH PASSWORD 'pass';
GRANT ALL PRIVILEGES ON DATABASE hiber1 to user1;