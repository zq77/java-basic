package com.z.service;

import java.util.List;

import javax.persistence.Transient;

import com.z.model.User;

public interface TxService {
	@Transient
	void save(User u);
	
	List<User> showAll();
}
