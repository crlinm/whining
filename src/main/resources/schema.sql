-- Создать schema.sql файл, который содержит описание таблиц и данных для этих таблиц
--
-- Товар
-- - id
-- - описание
-- - стоимость
-- - количество
--
-- Заказчик
-- - id
-- - имя/фамилия
--
-- Заказ
-- - id-товара (внешний ключ)
-- - id-заказчика (внешний ключ)
-- - дата заказа
-- - количество товаров
--
-- Написать 3-4 запроса на эти таблицы.


create table product
(
    id          integer generated always as identity primary key,
    description text,
    cost        numeric,
    count       integer
);


create table users
(
    id           bigint generated always as identity primary key,
    display_name text not null,
    nick_name    text not null unique ,
    email        text not null unique ,
    description  text not null default '',
    hash_password text not null
);

alter table users alter column description set default '';


create table whines
(
    id        bigint generated always as identity primary key,
    user_id   bigint      not null references users (id) on update cascade on delete cascade,
    whined_at timestamptz not null default current_timestamp,
    message   text        not null
);


create table followers
(
    reader_id bigint not null references users (id) on update cascade on delete cascade,
    writer_id bigint not null references users (id) on update cascade on delete cascade,
    primary key (reader_id, writer_id)
);


create table likes
(
    user_id bigint not null references users (id) on update cascade on delete cascade,
    whine_id bigint not null references whines (id) on update cascade on delete cascade,
    primary key (user_id, whine_id)
);

-- drop table orders, client;
-- drop table product cascade ;

delete
from users
where id = 12;



create table client
(
    id      integer generated always as identity primary key,
    name    text,
    surname text
);


create table orders
(
    product_id integer,
    foreign key (product_id) references product (id),
    client_id  integer,
    foreign key (client_id) references client (id),
    created_at timestamptz,
    amount     integer
);


insert into whines (user_id, whined_at, message) VALUES (1, now(), 'test');
insert into whines (user_id, whined_at, message) VALUES (1, now(), 'test1');
insert into whines (user_id, whined_at, message) VALUES (1, now(), 'test2');
insert into whines (user_id, whined_at, message) VALUES (1, now(), 'test3');
insert into whines (user_id, whined_at, message) VALUES (1, now(), 'test4');
insert into whines (user_id, whined_at, message) VALUES (2, now(), 'test5');

-- alter table if exists users
--     drop column hash_password;

select
    *
from
    whines
        left outer join
    users
    on whines.user_id=users.id
where
        users.id=1;

insert into product (description, cost, count)
values ('Стиральная машина BOSCH WLX 20463', 28990, 2);
insert into product (description, cost, count)
values ('Микроволновая печь SAMSUNG MW 87 HPR', 11990, 1);
insert into product (description, cost, count)
values ('Посудомоечная машина BOSCH SGS 44E12RU', 24999, 3);
insert into product (description, cost, count)
values ('Холодильник LG GC-051 SS', 35000, 3);


update product
set count = 11
where id = 2;


insert into client (name, surname)
VALUES ('Alina', 'M');
insert into client (name, surname)
VALUES ('aaa', 'vvv');


insert into orders (product_id, client_id, created_at, amount)
values (2, 1, now(), 5);
insert into orders (product_id, client_id, created_at, amount)
values (2, 1, now(), 1);
insert into orders (product_id, client_id, created_at, amount)
values (2, 2, now(), 1);
insert into orders (product_id, client_id, created_at, amount)
values (3, 1, now(), 1);

select *
from product
where cost > 20000;


-- удаляю ошибочно добавленную запись дважды
delete
from product
where id = 5;


select count(*)
from product;


select *
from orders o
         left join product p on o.product_id = p.id
where o.amount > 1;


select o.product_id, min(p.description), count(*) as cnt
from orders o
         inner join product p on o.product_id = p.id
group by o.product_id
having count(*) = 3;


select *
from orders;


select *
from product;
