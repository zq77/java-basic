package com.z.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;

import com.z.dao.UserDAO;
import com.z.utils.C3p0Utils;

public class UserDAOimpl1 implements UserDAO {

	public void save() {
		Connection conn = C3p0Utils.getConnection();
System.out.println("dao1 conn is : " + conn);
		String sql = "insert into user values(?,?)";
		
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(conn, sql, UUID.randomUUID().toString().replaceAll("-", ""), "灭国");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
