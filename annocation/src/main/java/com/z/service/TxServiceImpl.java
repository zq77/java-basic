package com.z.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.Transient;

import com.z.dao.TxDAO;
import com.z.dao.TxDAO2;
import com.z.model.User;

public class TxServiceImpl implements TxService {
	//注入两个dao
	TxDAO tx1 = new TxDAO();
	TxDAO2 tx2 = new TxDAO2();
	
	public void save(User u) {
		tx1.save(u);
		tx2.save(u);
	}

	public List<User> showAll() {
		return tx1.showAll();
	}
}
