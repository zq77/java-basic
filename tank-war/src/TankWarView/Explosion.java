package TankWarView;

import java.awt.*;

/**
 * 这是一个爆炸类		给爆炸了添加图片		一般画图片的时候用static
 * @author z
 *
 */
public class Explosion {			
	public int x, y;
	
	private boolean live = true;
	public static int i = 0;
	MyFrame mf = null;
	
//	Toolkit是一个工具包,	Toolkit.getDefaultToolkit()就可以拿到当前系统默认的工具包
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
//定义成静态变量因为在Bullet类的fighttank(Tank t)方法中new一个Explosion就会从硬盘上调用一次Image，定义成静态的就能直接调用	
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
	
//因为打第一发子弹不会发生爆炸	涉及到虚代理、、、、	所以打子弹碰坦克前先画一边爆炸
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
