create database Angular_SpringBoot;

use Angular_SpringBoot;

create table users(
id int primary key identity(1,1),
fullname varchar(100) default '',
phone_number varchar(10)not null,
address varchar(200) default '',
password varchar(100) not null default '',
created_at datetime,
updated_at datetime,
is_active tinyint default 1,
date_of_birth date,
facebook_account_id int default 0,
google_account_id int default 0
);
alter table users add role_id int;
alter table users add foreign key (role_id) references roles(id);

create table tokens(
id int primary key identity(1,1),
token varchar(255) unique not null,
token_type varchar(50) not null,
expiration_date datetime,
revoked bit not null,
expired bit not null,
user_id int,
foreign key (user_id) references users(id)
);

create table social_accounts(
id int primary key identity(1,1),
provider varchar(20) not null,
provider_id varchar(50) not null,
email varchar(150) not null,
name varchar(100) not null,
user_id int,
foreign key (user_id) references users(id)
);

create table categories(
id int primary key identity(1,1),
name varchar(100) not null default ''
);

create table products(
id int primary key identity(1,1),
name varchar(350),
price float not null check(price >=0),
url varchar(300) default '',
description varchar(max) default '',
created_at datetime,
updated_at datetime,
category_id int,
foreign key (category_id) references categories(id)
);

create table product_images(
id int primary key identity(1,1),
product_id int,
foreign key (product_id) references products(id),
constraint fk_product_images_product_id foreign key (product_id) references products(id) on delete cascade,
image_url varchar(300)
);

create table roles(
id int primary key,
name varchar(20) not null,
);

create table orders(
id int primary key identity(1,1),
user_id int,
foreign key (user_id) references users(id),
fullname varchar(100),
email varchar(100),
phone_number varchar(20) not null,
address varchar(200) not null,
note varchar(100) default'',
order_date datetime default current_timestamp,
status varchar(20),
total_money float check(total_money >= 0)
);

alter table orders add shipping_method varchar(100);
alter table orders add shipping_address varchar(200);
alter table orders add shipping_date date;
alter table orders add tracking_number varchar(100);
alter table orders add payment_method varchar(100);
alter table orders add active bit;
alter table orders
add constraint chk_status check (status in ('pending', 'processing', 'shipped', 'cancelled'));

create table order_details(
id int primary key identity(1,1),
order_id int,
foreign key (order_id) references orders(id),
product_id int,
foreign key (product_id) references products(id),
price float check(price >= 0),
number_of_products int check(number_of_products > 0),
total_money float check(total_money >= 0),
color varchar(20) default '',
);

select * from categories