package TankWarView;

import java.awt.*;

/**
 * ����һ����ը��		����ը�����ͼƬ		һ�㻭ͼƬ��ʱ����static
 * @author z
 *
 */
public class Explosion {			
	public int x, y;
	
	private boolean live = true;
	public static int i = 0;
	MyFrame mf = null;
	
//	Toolkit��һ�����߰�,	Toolkit.getDefaultToolkit()�Ϳ����õ���ǰϵͳĬ�ϵĹ��߰�
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
//����ɾ�̬������Ϊ��Bullet���fighttank(Tank t)������newһ��Explosion�ͻ��Ӳ���ϵ���һ��Image������ɾ�̬�ľ���ֱ�ӵ���	
	private static Image[] ima = {				
			tk.getImage(Explosion.class.getClassLoader().getResource("image/0.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/1.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/2.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/3.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/4.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/5.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/6.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/7.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/8.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/9.gif")),
			tk.getImage(Explosion.class.getClassLoader().getResource("image/10.gif")),
	};
	
//��Ϊ���һ���ӵ����ᷢ����ը	�漰�������������	���Դ��ӵ���̹��ǰ�Ȼ�һ�߱�ը
	private boolean onn = false;
	
	Explosion(int x, int y, MyFrame mf) {
		this.x = x;
		this.y = y;
		this.mf = mf;
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		if (!onn) {
			for (int i = 0; i<ima.length; i++) {
				g.drawImage(ima[i], x, y, null);
			}
			onn = true;
		}
		
		if(!live) return;
		if(i == ima.length) {
			i = 0;
			this.setLive(false);
		}
		g.drawImage(ima[i], x, y, null);
		
		i++;
	}
}
