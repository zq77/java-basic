package Tankwar1;

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
	int x = 200, y = 300;
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
		Color c= g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 40, 40);
		g.setColor(c);
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

//����һ���߳�ʹ�䲻���ػ�
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
		public void keyPressed(KeyEvent e) {
			int i = e.getKeyCode();
			if(i == KeyEvent.VK_UP) y -= 5;
			if(i == KeyEvent.VK_RIGHT) x += 5;
			if(i == KeyEvent.VK_LEFT) x -= 5;
			if(i == KeyEvent.VK_DOWN) y += 5;
		}
	}
}