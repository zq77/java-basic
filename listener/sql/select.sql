/*查询某个人拥有某个角色*/
select u.name,r.name from user u 
	join user_role ur on u.id = ur.user_id
	join role r on ur.role_id = r.id;
             
/*某角色拥有某权限*/
select r.name,p.name from role r 
	join privilege_role pr on r.id = pr.role_id
	join privilege p on pr.privilege_id = p.id;

             
/*查询某人拥有某个权限*/
select u.name,p.name from user u
	join user_role ur on u.id = ur.user_id
	join role r on ur.role_id = r.id
	join privilege_role pr on r.id = pr.role_id
	join privilege p on pr.privilege_id = p.id  where u.name = 'jack';
             
             
/*根据url和用户id断定这个用户 是否拥有某个权限*/
select count(*) from privilege p
	join privilege_role pr on p.id = pr.privilege_id
	join role r on pr.role_id = r.id
	join user_role ur on r.id = ur.role_id
	where ur.user_id='u0001' and url = '/role.jsp';