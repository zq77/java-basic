package com.z.safety_copy;

public class TestSafety {

	public static void main(String[] args) {
		String[] str = {"撒旦","耶稣"};
		Users u = new Users(str);
		u.show();
		
		System.out.println("============如果在一端改变参数，要做到另一端显示的还是不变=============");
		
		str[0] = "路西法";
		u.show();
	}
}
