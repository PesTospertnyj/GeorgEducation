/**********************************************
1. ??????? ? ?????????? Oracle XE 11gR2 ? SQL Developer, ????????? ??? ????????? ?????? ??? ????? SYS
https://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/xe-prior-releases-5172097.html - ??? ???? ORACLE XE
https://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.htm - SQL Developer

2. ????????? workspace ? APEX (??? ??? ????? ??? ???????? ???????????????? ?????, ? ??? ????? ??? ????? ????????),
? apex ????? ????? ???: http://localhost:8080/apex/

?????????? ?? ????????? ?????? ??????? ???:
https://www.youtube.com/watch?v=FAp0ics4-8E --????????? apex
https://www.youtube.com/watch?v=4dbB0C9KLac -- ????????? sql developer

3. ???????????? ? ?? ? ??????? SQL Developer 
https://www.youtube.com/watch?v=4dbB0C9KLac -- ????????? sql developer

************************************************/



/************aggregation (max, min, avg, sum, count), group by, having **********************/
select * from emp
---- ??? 3 ????????? ??????? ?????????? ???? ? ??? ?? ?????????, ?? ?????? ????? ???????????--------------
select count(1) from emp
select count(*) from emp
select count(empno) from emp 
----
select count(1) from emp where comm>100 
select count(1) from emp where comm<0 --?????????? ?????? ?? null, ???? ???? ??? ?????, ??????????????? ???????? where

--------?????-- sum ????????? ??? ???????? ???????? ----
select * from emp 
select sum(comm) from emp where comm is not null 
select sum(comm) from emp where empno in (7839,7499) and comm is not null
select * from emp 
---group by
select deptno, avg(sal), min(sal), max(sal), sum(sal) from emp group by deptno 
select deptno, avg(sal), min(sal), max(sal), sum(sal) from emp --??? group by ?????????? ?????? ORA-00937

select deptno, job, avg(sal), min(sal), max(sal), sum(sal) from emp group by deptno, job  

select deptno, avg(sal), min(sal), max(sal), sum(sal) from emp group by deptno, job 
---having n
select deptno, avg(sal), min(sal), max(sal), sum(sal) from emp group by deptno having sum(sal)>9000
----
select deptno, avg(sal), min(sal), max(sal), sum(sal) from emp 
where deptno in (20,30)  group by deptno having sum(sal)>9000

---group by, order by
select * from emp 
select deptno, avg(sal), min(sal), max(sal), sum(sal) from emp group by deptno, job  order by sum(sal)

------ case ----

select ename,
       sal,
     (case 
         when sal>=3000 then 'HIGHT SALARY'
         when sal<3000 and sal>=1000 then 'MIDDLE SALARY'
         when sal<1000 then 'LOW SALARY'
        end) "Size of salary"
        from emp
        -----------------------
        
---
select ename, 
       deptno, 
       (case deptno
       when 10 then 'MAJOR'
       else '-'
       end) "is_major" 
       from emp
 /********************** JOINS  *********************************/   
 select * from demo_orders 
 select * from demo_customers 
 
 -- INNER JOIN --
 
 --ANSI--
 select dc.cust_first_name, 
        cust_last_name, 
        order_id, 
        order_total
   from demo_customers dc join demo_orders do on (dc.customer_id=do.customer_id)
   where 
   dc.credit_limit>10
   --do.order_total>1000
 ---------------
  select *
   from demo_customers dc join demo_orders do on (dc.customer_id=do.customer_id)
   where do.order_total>1000
 --------------
 select dc.cust_first_name, do.*
   from demo_customers dc join demo_orders do on (dc.customer_id=do.customer_id)
   where do.order_total>1000
 -----------
 
 select * from emp 
 --------------
 select 
 employee.ename "EMPLOYEE", boss.ename "BOSS", boss.deptno "BOSS_dept"
 from emp employee join emp boss on (boss.empno=employee.mgr)
 
 
 --------
 
 select dc.cust_first_name, 
        cust_last_name, 
        order_id, 
        order_total
   from demo_customers dc, demo_orders do
   where dc.customer_id=do.customer_id
   and dc.credit_limit>10
   
   
 ------- OUTER JOINS---
 insert into demo_customers 
 values(25,'Gomer','Simpson','Super-address',null,'Super-city','MA',123,'12-125',null,500,null)
 commit;
 
 select * from demo_customers 
 select * from demo_orders where customer_id=21 
 
 select dc.cust_first_name, 
        cust_last_name, 
        order_id, 
        order_total
   from demo_customers dc left join demo_orders do on (dc.customer_id=do.customer_id)
   where dc.credit_limit>10
 ----- ?? ?? ?????, ??? -
select dc.cust_first_name, 
        cust_last_name, 
        order_id, 
        order_total
   from demo_orders do right join demo_customers dc   on (dc.customer_id=do.customer_id)
   where dc.credit_limit>10
 ---------------------------
 select dc.cust_first_name, 
        cust_last_name, 
        order_id, 
        order_total
        from demo_orders do, demo_customers dc
        where do.customer_id(+)=dc.customer_id
        and dc.credit_limit>10
        -----------------------
        
        select * from demo_orders do, demo_customers dc
        select * from demo_orders do join demo_customers dc on (1=1) 
 
 
 
 
 ---------??????????-----
 select * from demo_customers where customer_id not in (select customer_id from demo_orders)
 select * from demo_customers where customer_id not in (select * from demo_orders) --?????? 
 select * from demo_customers where customer_id not in (select order_timestamp from demo_orders) --?????? 
 ------------
 select * from demo_orders 
 
 select
 order_id,
 customer_id,
 (select cust_first_name from demo_customers dc where dc.customer_id=do.customer_id) "Customer name"
 from demo_orders do
 -----------
              