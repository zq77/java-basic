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
		tank.draw(g);
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
		@Override
		public void keyReleased(KeyEvent e) {
			tank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			tank.keyPressed(e);
		}
		
	}
}