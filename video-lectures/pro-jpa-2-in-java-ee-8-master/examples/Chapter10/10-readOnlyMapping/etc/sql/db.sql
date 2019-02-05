DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;
CREATE TABLE DEPARTMENT (ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE EMPLOYEE (ID INTEGER NOT NULL, NAME VARCHAR(255), SALARY BIGINT, DEPT_ID INTEGER, PRIMARY KEY (ID), 
                       CONSTRAINT DEPT_FK FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(ID));

INSERT INTO DEPARTMENT(ID, NAME) VALUES (1, 'Engineering');
INSERT INTO DEPARTMENT(ID, NAME) VALUES (2, 'Human Resources');
INSERT INTO EMPLOYEE (ID, NAME, SALARY, DEPT_ID) VALUES (1, 'Jane Smith', 43000, 1);
INSERT INTO EMPLOYEE (ID, NAME, SALARY, DEPT_ID) VALUES (2, 'John Plaid', 40000, 2);
INSERT INTO EMPLOYEE (ID, NAME, SALARY, DEPT_ID) VALUES (3, 'Bob Danish', 51000, 1);
