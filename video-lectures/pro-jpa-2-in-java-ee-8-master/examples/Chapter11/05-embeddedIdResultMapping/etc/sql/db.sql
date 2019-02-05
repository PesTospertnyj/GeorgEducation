DROP TABLE EMP;

CREATE TABLE EMP (COUNTRY VARCHAR(255) NOT NULL, EMP_ID INTEGER NOT NULL, NAME VARCHAR(255),
                  SALARY BIGINT, MANAGER_COUNTRY VARCHAR(255), MANAGER_ID INTEGER, PRIMARY KEY(COUNTRY,EMP_ID),
                  CONSTRAINT MGR_FK FOREIGN KEY (MANAGER_COUNTRY,MANAGER_ID) REFERENCES EMP (COUNTRY,EMP_ID));

INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('Canada', 1, 'Joan', 59000, NULL, NULL);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('US', 2, 'Sarah', 52000,  'Canada', 1);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('US', 3, 'John', 55000, 'US', 2);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('US', 4, 'Rob', 53000, 'US', 2);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('US', 5, 'Peter', 50000, 'US', 2);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('Canada', 6, 'Frank', 51000, 'Canada', 1);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('US', 7, 'Scott', 60000, 'Canada', 1);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('Canada', 8, 'Sue', 62000, 'Canada', 1);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('US', 9, 'Stephanie', 54000, 'Canada', 1);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('Canada', 10, 'Jennifer', 55000, NULL, NULL);
INSERT INTO EMP (COUNTRY, EMP_ID, NAME, SALARY, MANAGER_COUNTRY, MANAGER_ID) VALUES ('Canada', 11, 'Marcus', 35000, NULL, NULL);
