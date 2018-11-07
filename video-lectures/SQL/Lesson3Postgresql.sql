-------------------создание таблицы ------------------------------
CREATE TABLE department (
    id INT PRIMARY KEY, --первичный ключ, уникальные значения
    dep_name VARCHAR(100),
    head_dep_id INT,
    is_actual VARCHAR(1),
    FOREIGN KEY (head_dep_id) --внешний ключ, ссылается на эту же таблицу, но может и на другую
        REFERENCES department (id)
);

-------------- создание таблицы на основе существующей -----------------------------------------

create table department_new as select * from department

--------------Создание пустой таблицы на основе существующей -------------

create table department_empty as select * from department where 1=0

-------------- Добавление колонок в таблицу -------------------
alter table department add column region_name VARCHAR(30);

select * from department --видим новую колонку

--------------- Удаление колонки из таблицы --------------------------------
alter table department drop column region_name 

select * from employee 
---------------Вставка записей в таблицу INSERT----------------
insert into employee values (100,'NewMan','NewEmployee',1002,25,125,current_date, null, 1000);
--commit

-------------Изменение записей UPDATE------------------------------
update employee set salary=1100 where id=100;
commit;


------------- Conditional UPDATE почему-то не работает тут, хотя должен. 
--https://www.postgresql.org/message-id/keviaq$8bh$3%40gonzo.reversiblemaps.ath.cx
--------------- В оракле работает--------------------------------------
update employee set salary=case when salary>1000 then salary*0.99
                                 when salary<=1000  then salary*1.01
							end;	 

------------Удаление записей DELETE----------------------------------------

delete from employee where id=165
select * from employee where id=165 --видно, что строки нет 
rollback --отменили удаление
select * from employee where id=165

---------------Очистка таблицы TRUNCATE -------------
--TRUNCATE - это DDL операция, поэтому при выполнении ROLLBACK данные  не восстанавливаются
create table employee_test as select * from employee 
select * from employee_test 
truncate table employee_test
select * from employee_test 
rollback 
select * from employee_test 


---------Понятие транзакции ------------------
--ACID A-atomicity, C - consistency, I -isolation, D -durability
-- хороший пример тут для чего нужны транзакции https://postgrespro.ru/docs/postgrespro/10/tutorial-transactions
--- Уровни изоляции транзакций согласно ANSI
-- READ UNCOMMITED -- "грязное чтение" - не поддерживается в Oracle и PostgreSQL
-- READ COMMITED -- установлен по умолчанию
-- REPEATABLE READ
-- SELIALIZABLE  


create table account_balance (account_id INT, Balance_AMOUNT NUMERIC , USER_ID INT )
create table entries (deb_account_id INT, 
					  cred_account_id INT, 
					  AMOUNT NUMERIC, entry_date DATE, is_deleted VARCHAR(1))
-------
	select * from entries 	
	select * from account_balance 	
	drop table account_balance 																											   
																												   
	begin																											   
	--insert into account_balance values (125, 10000,1);
	insert into account_balance values (126, 100,1);	
	insert into account_balance values(127, 500,1);	
    commit;
	--rollback 
																												   
	----- транзакция по переносу денег с счета на счет-----------------------------																											   
	begin; --особенности postgressql
    update account_balance set balance_amount=balance_amount - 100 where account_id=125;
    update account_balance set balance_amount=balance_amount + 100 where account_id=126;
	insert into entries values(125,126,100,current_date,'Y');
	commit;
																												 
																												   
																												   
---------
select * from account_balance
	--------------- with clause---------------------																											   
with tab1 as 
 (select e.id, e.first_name, e.last_name, d.dep_name 
  from employee e join department d on (e.dep_id=d.id))
select * from tab1															  
																												   
																												   ---



