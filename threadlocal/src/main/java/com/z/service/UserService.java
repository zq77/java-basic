package com.z.service;

import com.z.dao.UserDAO;
import com.z.dao.impl.UserDAOimpl1;
import com.z.dao.impl.UserDAOimpl2;

/**
 * 这是业务逻辑层，相当于controller，用来管理dao的
 * @author z
 *
 */
public class UserService {

	private UserDAO dao1 = new UserDAOimpl1();
	private UserDAO dao2 = new UserDAOimpl2();
	
	//单例模式
	public static UserService userService;
	public static UserService newInstance() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}
	
	public void save() {
		dao1.save();
		dao2.save();
	}
}
