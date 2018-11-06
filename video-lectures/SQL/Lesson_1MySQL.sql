
https://docs.google.com/presentation/d/13y_34g5bM2XXcIoQNWET2UFCEMME5CNQopMJ7G1hsa4/edit?usp=sharing

drop table employee;

CREATE TABLE employee (
    id INT PRIMARY KEY,
    First_name VARCHAR(100),
    Last_name VARCHAR(100),
    dep_id INT,
    position_id INT,
    boss_id INT,
    hire_date DATE,
    fire_date DATE,
    salary NUMERIC,
    FOREIGN KEY (dep_id)
        REFERENCES department (id),
    FOREIGN KEY (position_id)
        REFERENCES positions (id),
        FOREIGN KEY (boss_id)
        REFERENCES employee (id)
);
 drop table department;
CREATE TABLE department (
    id INT PRIMARY KEY,
    dep_name VARCHAR(100),
    head_dep_id INT,
    is_actual VARCHAR(1),
    FOREIGN KEY (head_dep_id)
        REFERENCES department (id)
);
drop table positions;
CREATE TABLE positions (
    id INT PRIMARY KEY,
    pos_name VARCHAR(100),
    is_actual VARCHAR(1)
);


Create table account (account_id int primary key,
                      balance NUMERIC);

/*************************/
insert into department values (100, 'CHIEF_DEP', NULL, 'Y'), (101, 'IT-department', 100, 'Y'), (102, 'OLD_DELETED_Department', 100, 'N');
insert into department values (1001, 'IT.Support',101,'Y'),
                              (1002,'IT.Development',101,'Y'),
                              (1003,'IT.Testing',101,'Y'),
                              (1004,'IT.Analytics',101,'Y'),
                              (1005,'IT.ProjectOffice',101,'Y');
insert into department values (103,'FInansial Department',100,'Y'),(2001,'Accounting',103,'Y'), (104,'PR Department',100,'Y')     
commit;       
select * from department         
insert into positions values  (1, 'BOSS','Y'),
						     (2,'IT Director', 'Y'),
                             (3,'Finansial Director','Y'),
                             (25,'Software Developer','Y'),
                             (30,'QA','Y'),
                             (35,'Analytic','Y'),
                             (205,'Accountant','Y') ,
                             (4,'PR Director','Y'),
                             (305,'1-st line support','Y'), 
                             (380,'2-nd line support','Y'),
                             (15,'Old deleted position','N');
 commit;                            
 select * from positions 
 /*******************************/
 delete from employee;
 insert into employee values(11, 'Join-а', 'Joinson',100,1,null,date('1990-01-01'),null, 10000000);
 insert into employee values(125,'Gomer','Simpson',101,2,11,date('1995-01-01'),null, 2000),
                     (136,'Marth','Simpson',103,3,11,date('1995-01-01'),null,1000),
                      (140, 'Bart','Simpson',1002,25,125, date('2000-01-03'),null, 500),
                      (150, 'Lisa','Simpson',1002,25,125,date('2000-01-04'),null, 490),
                      (165, 'Tom', 'Cat', 1002,25,125,date ('1999-05-08'),null,800),
                      (160, 'Jerry','Mouse',1002,25,125,date('1998-12-06'),null,750),
                    (145, 'Bad','Guy',1002,25,125,date('1999-12-30'),date('2000-01-01'),null),
                      (100056,'Maggy','Sympson',103,205,136,date('2005-01-01'),null, 300);
     commit; 
     
  insert into account values(1,10000),(120,-122003.25),(25,1520.02),(5456, -852000.05)
  commit;
  
  select * from account 
  
   select 1 from dual 
  
/*********************************************************/
/************выбор одного либо нескольких полей, табличные алиасы*******************************/
select dep_name from department 
select department.dep_name from department 
select d.dep_name from department d

select id, dep_name from department
select id, dep_name, is_actual from department 
select last_name from employee 
select last_name, dep_id from employee 

select distinct last_name from employee
select distinct last_name, dep_id from employee
/************выбор всех полей таблицы*******************************/
select * from department 
select * from employee
select * from positions

select id, dep_name from department

/*************виртуальные колонки, столбцовые алиасы********************************************/
SELECT 
    first_name 'Имя',
    last_name 'Фамилия',
    salary 'Зарплата',
    salary * 0.87 'Зарплата на руки'
FROM
    employee
select first_name 'Имя', last_name 'Фамилия', salary 'Зарплата', salary*0.87 'Зарплата на руки', 1 'Просто цифра' from employee 
select first_name, last_name, dep_id, 777 from employee



/************условие where =>< between like, not like, in, not in, null, is not null*******************************/
select dep_name, is_actual from department where is_actual='N'
select first_name, last_name, salary  from employee where salary>500
select * from employee where salary between 300 and 1000
select * from employee where last_name not like 'S%'
select * from employee where last_name like 'S%m%'
select * from employee where first_name like '_isa'
select * from employee where first_name in ('Lisa','Bart')
select * from employee where first_name not in ('Marth','Gomer')
select * from employee where first_name!= 'Lisa' and last_name like 'S%'
select * from employee where salary>2000 or salary<500
select * from employee where boss_id is not null 


/************is null, is not null*******************************/ 
select * from employee where fire_date=null 
select salary+null from employee
select * from employee where fire_date is null 
select first_name, last_name, salary, salary*0.87 from employee  where fire_date is null 
select first_name 'Имя', last_name 'Фамилия', salary 'Зарплата', salary*0.87 'Зарплата на руки' from employee  where fire_date is null 
select * from employee where fire_date is not null

/************order by*******************************/
select * from employee order by salary
select * from employee order by salary asc 
select * from employee order by salary desc 


select * from employee order by last_name desc, salary
select first_name, last_name from employee order by 1
select * from employee order by 1
select * from employee order by salary is null , salary desc /* nulls last*/ 
select * from employee order by salary is null desc, salary desc /* nulls first*/ 
select * from employee order by last_name asc, salary desc


/**********************union, union all***********************************************/


select first_name , last_name , salary from employee where hire_date>date('1998-12-06')
union all
select first_name , last_name ,  salary from employee where fire_date is not null


select first_name , last_name , salary from employee where hire_date>date('1998-12-06')
union
select first_name , last_name ,  salary from employee where fire_date is not null
order by first_name

select first_name , last_name , salary, 1 "query_num"  from employee where hire_date>date('1998-12-06')
union
select first_name , last_name ,  salary, 2  from employee where fire_date is not null
order by "query_num"



/************aggregation (max, min, avg, sum, count), group by, having **********************/
select max(salary), min(salary), avg(salary) from employee 
select max(salary), min(salary), avg(salary),  dep_id from employee /*err*/
select max(salary), min(salary), avg(salary), dep_id from employee  group by dep_id 
select sum(salary), dep_id from employee /*err*/
select sum(salary), dep_id from employee group by dep_id


select sum(salary), dep_id,position_id from employee group by dep_id, position_id


select sum(salary), dep_id from employee group by dep_id order by sum(salary)
select sum(salary), dep_id from employee group by dep_id order by avg(salary) 


select sum(salary), dep_id from employee group by dep_id having sum(salary)>500
select sum(salary), dep_id where dep_id=101 from employee group by dep_id having sum(salary)>500

select count(id) from employee 
select count(1) from employee 
select count(id) from employee where first_name like 'R%' /*no records, returns 0, (NOT NULL!)*/
select count(null) from employee 
select sum(salary) from employee 

/************посчитать сумму всех положительных и отрицательных чисел в столбце*****************************/
select sum(balance+abs(balance))/2 pos_sum, sum(balance-abs(balance))/2 neg_sum from account 



/********************case*********************************/
SELECT 
    first_name,
    last_name,
    CASE
        WHEN dep_id = 100 THEN 'BOSS_DEPARTMENT'
        WHEN dep_id = 1002 THEN 'development'
        ELSE 'others'
    END
FROM
    employee
    


