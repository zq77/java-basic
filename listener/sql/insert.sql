insert into user values('U001','Jack','1234');
insert into user values('U002','张三','4321');
insert into user values('U003','Tom','1111');

insert into role values('R001','管理员','');
insert into role values('R002','教师','');

insert into user_role values('U001','R001');
insert into user_role values('U002','R002');

insert into privilege values('M001','系统管理','/sys.jsp');
insert into privilege values('M002','用户管理','/user.jsp');
insert into privilege values('M003','角色管理','/role.jsp');

insert into privilege_role values('M001','R001');
insert into privilege_role values('M002','R001');
insert into privilege_role values('M003','R001');
insert into privilege_role values('M003','R002');