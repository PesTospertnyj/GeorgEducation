create table Message
(
  id bigint auto_increment PRIMARY KEY ,
  text varchar(255)
);

insert into Message(id, text)
values (1, 'first');

commit;