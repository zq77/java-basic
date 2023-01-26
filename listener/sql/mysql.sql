/*user表*/
create table user (
	id varchar(32) primary key,
	name varchar(50),
	password varchar(32)
);
/*role表*/
create table role (
	id varchar(32) primary key,
	name varchar(50),
	description varchar(200)
);
/*通过一个中间表映射多对多的关系,多对多就是多个一对多
	联合主键的特点是：两个列不能同时重复
*/
create table user_role (
	user_id varchar(32),
	role_id varchar(32),
	constraint ur_pk primary key(user_id,role_id),
	constraint u_fk foreign key(user_id) references user(id),
	constraint r_fk foreign key(role_id) references role(id)
);
/*Privilege表*/
create table privilege (
	id varchar(32) primary key,
	name varchar(50),
	url varchar(100)
);
/*声明的外键名字是不能相同的*/
/*role和privilege的中间表*/
create table privilege_role (
	privilege_id varchar(32),
	role_id varchar(32),
	constraint pr_pk primary key(privilege_id,role_id),
	constraint pr_fk foreign key(privilege_id) references privilege(id),
	constraint rp_fk foreign key(role_id) references role(id)
);