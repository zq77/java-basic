package com.z.dao;

import java.util.UUID;

import com.z.model.User;
import com.z.utils.C3p0Utils;
import com.z.utils.QueryRunner;

/**
 * 
 * @author z
 *
 */
public class TxDAO2 {
	
	public void save(User u) {
		String sql = "insert into user(id,name,password) values(?,?,?)";
		
		QueryRunner run = new QueryRunner();
		
		run.update(C3p0Utils.getThreadConnection(), sql, 
				UUID.randomUUID().toString().replaceAll("-", ""), u.getName(), u.getPassword());
	}
}
