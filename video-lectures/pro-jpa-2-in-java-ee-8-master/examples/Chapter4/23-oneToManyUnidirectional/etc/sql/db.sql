DROP TABLE EMP_PHONE;
DROP TABLE EMPLOYEE;
DROP TABLE PHONE;

CREATE TABLE PHONE (ID INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
                    TYPE VARCHAR(255), NUM VARCHAR(32), PRIMARY KEY (ID));
CREATE TABLE EMPLOYEE (ID INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
                       NAME VARCHAR(255), SALARY BIGINT, PRIMARY KEY (ID));
CREATE TABLE EMP_PHONE (PHONE_ID INTEGER NOT NULL, EMP_ID INTEGER NOT NULL,
                        CONSTRAINT PHONE_FK FOREIGN KEY (PHONE_ID) REFERENCES PHONE (ID),
                        CONSTRAINT EMP_FK FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE (ID),
                        PRIMARY KEY (PHONE_ID, EMP_ID))

-- CREATE TABLE EMP_PHONE (PHONE_NUM VARCHAR(32) NOT NULL, EMP_ID INTEGER NOT NULL,
--                         -- CONSTRAINT PHONE_FK FOREIGN KEY (PHONE_NUM) REFERENCES PHONE (NUM),
--                         CONSTRAINT EMP_FK FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE (ID),
--                         PRIMARY KEY (PHONE_NUM, EMP_ID))