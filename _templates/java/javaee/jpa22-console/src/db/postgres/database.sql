SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'jpa1' -- ← change this to your DB
  AND pid <> pg_backend_pid();

drop database jpa1;
drop user user1;

CREATE DATABASE jpa1;
CREATE USER user1 WITH PASSWORD 'pass';
GRANT ALL PRIVILEGES ON DATABASE jpa1 to user1;