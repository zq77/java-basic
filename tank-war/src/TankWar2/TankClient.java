package TankWar2;

import java.awt.*;
import java.awt.event.*;

public class TankClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.windows();

	}

}

class MyFrame extends Frame {
	Tank tank = new Tank(200,300);
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
	
	public void paint(Graphics g) {			//把g想象成一个带颜色的画笔
		tank.draw(g);
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

//创建一个线程使其不断重画
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
		}
		
	}
}