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
//new TimeHandler(move) ���Ըı䣬����������־��Ҳ������������
		InvocationHandler h = new TimeHandler(move);
		//InvocationHandler h = new TransactionHandler(move);
		
//�����дmove.getClass(); ��ô��Proxy���оͻ���������õ��ķ���������ӡ��������Ϊmove.getClass()�õ��˷��䣬���Ի���ʾ�����õ��ķ����������߳�
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
		System.out.println("��hibernate�е��ӳټ���һ��" + m.getClass());
		m.move();
	}

}

