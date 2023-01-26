package com.z.service;

import java.util.List;

import com.z.dao.UserDAO;
import com.z.model.Privilege;
import com.z.model.User;

public class UserService {
	private UserDAO userdao = new UserDAO();
	//单例模式
	private static UserService service;
	public static UserService newInstance() {
		if(service == null) {
			service = new UserService();
		}
		return service;
	}
	//判断用户能否登录
	public User existUser(User u) {
		return userdao.existUser(u);
	}
	//判断用户是否有该权限
	public int checkPrivilege(User user, String uri) {
		return userdao.checkPrivilege(user,uri);
	}
	public List<Privilege> privilegeList(User user) {
		return userdao.privilegeList(user);
	}
}
