import com.z.proxy.InvocationHandler;
import com.z.proxy.Moveable;
import com.z.proxy.Proxy;
import com.z.proxy.Tank;
import com.z.proxy.TimeHandler;
import org.junit.Test;



public class Proxytest {
	
	@Test
	public void testMove() throws Exception {
		Moveable move = new Tank();
//new TimeHandler(move) 可以改变，可以生成日志，也可以生成事物
		InvocationHandler h = new TimeHandler(move);
		//InvocationHandler h = new TransactionHandler(move);
		
//这如果写move.getClass(); 那么在Proxy类中就会把他所有用到的方法名都打印出来，因为move.getClass()用到了反射，所以会显示所有用到的方法，包括线程
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
		System.out.println("和hibernate中的延迟加载一样" + m.getClass());
		m.move();
	}

}

