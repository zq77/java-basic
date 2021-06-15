package com.z.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.z.model.User;
import com.z.utils.C3p0Utils;
import com.z.utils.QueryRunner;

/**
 * 
 * @author z
 *
 */
public class TxDAO {
	
	public void save(User u) {
		String sql = "insert into user(id,name,password) values(?,?,?)";
		
		QueryRunner run = new QueryRunner();
		
		run.update(C3p0Utils.getThreadConnection(), sql, 
				u.getId(), u.getName(), u.getPassword());
	}

	public List<User> showAll() {
		String sql = "select * from user";
		QueryRunner run = new QueryRunner();
		
		List<User> l =  run.query(C3p0Utils.getThreadConnection(), sql, new BeanListHandler<User>(User.class));
		
		return l;
	}
}
