package tankwar6;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import tankwar6.Tank.Direction;

/**
 * 这个类是坦克运行的主窗口类
 * @author Z
 *
 */
public class TankClient {

	/**
	 * 这个坦克是有问题的，当按住左上键的时候发不出炮弹			当判断两个物体碰撞时，用Rectangle类，一般在移动的类中写	  碰撞	方法
	 */
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.windows();

	}

}

class MyFrame extends Frame {
	Tank tank = new Tank(200,300,this,true,Direction.stop);
	Wall wall1 = new Wall(100,200,200,20,this);
	Wall wall2 = new Wall(200,200,20,200,this);
	Blood b = new Blood(this);

	List<Bullet> list = new ArrayList<Bullet>();
	List<Explosion> list1 = new ArrayList<Explosion>();
	List<Tank> list2 = new ArrayList<Tank>();
	
	Image backgroundImage = null;				//定义一个背景图
	public static final int GAME_WIDTH = 800;	//定义两个以后经常改动的常量
	public static final int GAME_HEIGHT = 600;	

	public void windows() {
		this.setTitle("Tank War");
		this.setBounds(270, 65, GAME_WIDTH, GAME_HEIGHT);
		this.setBackground(Color.green);
		KeyPass kp = new KeyPass();
		this.addKeyListener(kp);
		this.setResizable(false);
		this.setVisible(true);

//定义关闭窗口的方法
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		new Thread(new KetThread()).start();
		
	}
	
	public void paint(Graphics g) {				//把g想象成一个带颜色的画笔
		g.drawString("time is :" + new Date(), 10, 110);
		g.drawString("Bullet count is"+list.size(), 10, 50);
		g.drawString("Explosion count is"+list1.size(), 10, 70);
		g.drawString("Enemy count is"+list2.size(), 10, 90);
		g.drawString("Tank is life : " + tank.getLife(), 10, 130);

		wall1.draw(g);
		wall2.draw(g);
		b.draw(g);
		
		for(int i=0; i<list2.size(); i++) {
			Tank e = list2.get(i);
			e.meetTank(tank);
			e.meetTanks(list2);
			e.meetWall(wall1);
			e.meetWall(wall2);
			if(e.isLive()) e.draw(g);
			else list2.remove(i);
			
		}
		
		for(int i=0; i<list.size(); i++) {			//子弹攻击坦克
			Bullet bullet = list.get(i);
			bullet.fighttanks(list2);
			bullet.fighttank(tank);
			bullet.meetWall(wall1);
			bullet.meetWall(wall2);
			if(bullet.isLive()) bullet.draw(g);
			else list.remove(i);
		}
		
		for(int i=0; i<list1.size(); i++) {
			Explosion e = list1.get(i);
			if(e.isLive()) e.draw(g);
			else list1.remove(i);
		}
		
		if(tank.isLive()) {
			tank.eatBlood(b);
			tank.meetWall(wall1);
			tank.meetWall(wall2);
			tank.draw(g);
		}
		
	}

//使用双缓存，使图片不会再连续闪,注意repaint()方法的使用		相当于使用了画布
	@Override
	public void update(Graphics g) {
		if(backgroundImage == null) {
			backgroundImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gBGImage = backgroundImage.getGraphics();
		Color c= gBGImage.getColor();
		gBGImage.setColor(Color.green);
		gBGImage.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gBGImage.setColor(c);
		paint(gBGImage);
		g.drawImage(backgroundImage, 0, 0, null);
	}

//创建一个线程使图像不断重画 paint（）
	private class KetThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
//创建一个键盘事件，每当按一下指定的键，上面的线程开始重画就会发生变化
	private class KeyPass extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			tank.keyReleased(e);
			
		}

		public void keyPressed(KeyEvent e) {
			tank.keyPressed(e);
			int i = e.getKeyCode();
			if(i == KeyEvent.VK_1) add();
			if(i == KeyEvent.VK_3) list2.removeAll(list2);
		}
		
	}
	
	private void add() {			//添加敌对tank
		for(int i=0; i<10; i++) {			//声名10量敌对坦克
			list2.add(new Tank((int)(Math.random()*1000-200),(int)(Math.random()*1000-300),this,false,Direction.l));
		}
	}
}