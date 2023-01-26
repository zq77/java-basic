import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import sun.misc.BASE64Encoder;

/**
 * MessageDigest类是用来加密的
 * BASE64Encoder是用来编码的
 * @author z
 *
 */
public class TestEncode {

	@Test
	public void testBASE64Encoder() {
		String name = "z13903417792";
		String password = "q123456";
		BASE64Encoder en = new BASE64Encoder();
		name = en.encode(name.getBytes());
		password = en.encode(password.getBytes());
		System.out.println(name);
		System.out.println(password);
		
	}
	
	/**
	 * java.security MessageDigest 类是用来加密的
	 */
	@Test
	public void testShaDigest() {
		String str = "z123456";
		try {
			//sha加密
			MessageDigest sha = MessageDigest.getInstance("SHA");
			
			byte[] b = sha.digest(str.getBytes());
			
			System.out.println("没使用BASE64Encoder前 ： " + b.toString());
			
			BASE64Encoder en = new BASE64Encoder();
			str = en.encode(b);
			System.out.println("使用BASE64Encoder后 ： " + str);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMd5Digest() {
		String str = "z123456";
		try {
			//md5加密
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			
			byte[] b = md5.digest(str.getBytes());
			
			System.out.println("没使用BASE64Encoder前 ： " + b.toString());
			
			BASE64Encoder en = new BASE64Encoder();
			str = en.encode(b);
			System.out.println("使用BASE64Encoder后 ： " + str);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
