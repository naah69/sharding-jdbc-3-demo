drop table if exists t_order_0;
drop table if exists t_order_1;

create table t_order_0 (
  id bigint primary key auto_increment,
  order_id int not null ,
  user_id int not null
);

create table t_order_1 (
  id bigint primary key auto_increment,
  order_id int not null ,
  user_id int not null
);

