package tankwar3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import tankwar3.Tank.Direction;

public class TankClient {

	/**
	 * ���̹����������ģ�����ס���ϼ���ʱ�򷢲����ڵ�
	 */
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.windows();

	}

}

class MyFrame extends Frame {
	Tank tank = new Tank(200,300,this,true);
	Tank enemy = new Tank(100,30,this,false);
	List<Bullet> list = new ArrayList<Bullet>();
	Image backgroundImage = null;				//����һ������ͼ
	public static final int GAME_WIDTH = 800;	//���������Ժ󾭳��Ķ��ĳ���
	public static final int GAME_HEIGHT = 600;	

	public void windows() {
		this.setTitle("Tank War");
		this.setBounds(270, 65, GAME_WIDTH, GAME_HEIGHT);
		this.setBackground(Color.green);
		KeyPass kp = new KeyPass();
		this.addKeyListener(kp);
		this.setResizable(false);
		this.setVisible(true);

//����رմ��ڵķ���
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		new Thread(new KetThread()).start();
	}
	
	public void paint(Graphics g) {			//��g�����һ������ɫ�Ļ���
		g.drawString("�ӵ������"+list.size(), 10, 50);

		tank.draw(g);
		enemy.draw(g);
		for(int i=0; i<list.size(); i++) {
			Bullet bullet = list.get(i);
			if(bullet.isLive()) bullet.draw(g);
			else list.remove(i);
		}
	}

//ʹ��˫���棬ʹͼƬ������������,ע��repaint()������ʹ��		�൱��ʹ���˻���
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

//����һ���߳�ʹͼ�񲻶��ػ� paint����
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

//����һ�������¼���ÿ����һ��ָ���ļ���������߳̿�ʼ�ػ��ͻᷢ���仯
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