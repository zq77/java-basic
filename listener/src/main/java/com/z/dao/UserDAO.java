package com.z.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.z.model.Privilege;
import com.z.model.User;
import com.z.utils.C3p0Utils;

public class UserDAO {
	//判断用户是否存在
	public User existUser(User u) {
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user where name = ? and password = ?";
		User user = null;
		try {
			user = run.query(sql, new BeanHandler<User>(User.class), u.getName(), u.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//判断用户是否有该权限
	public int checkPrivilege(User user, String uri) {
		QueryRunner run = new QueryRunner();
		
		String sql = "select count(*) from privilege p" +
					 " join privilege_role pr on p.id = pr.privilege_id" +
					 " join role r on pr.role_id = r.id" +
					 " join user_role ur on r.id = ur.role_id" +
					 " where ur.user_id=? and url = ?";
		Object o = null;
		try {
			o = run.query(C3p0Utils.getThreadConnection(),sql,new ScalarHandler(),user.getId(),uri);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(o.toString());
	}
	//得到当前用户所有的权限
	public List<Privilege> privilegeList(User user) {
		QueryRunner run = new QueryRunner();
		String sql = "select p.* from user u" +
					" join user_role ur on u.id = ur.user_id" +
					" join role r on ur.role_id = r.id" +
					" join privilege_role pr on r.id = pr.role_id" +
					" join privilege p on pr.privilege_id = p.id  where u.id = ?";
		 List<Privilege> list = null;
		try {
			list = run.query(C3p0Utils.getThreadConnection(), sql, new BeanListHandler<Privilege>(Privilege.class), user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
