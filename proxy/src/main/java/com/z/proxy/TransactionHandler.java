package com.z.proxy;

import java.lang.reflect.Method;


public class TransactionHandler implements InvocationHandler {
	private Object target;
	
	public TransactionHandler(Object target) {
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("Transaction Start");

		try {
//���invoke�Ƿ��䣬ѡȡ���ǵײ�����е�m����
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Transaction Commit");
	}

}
