package tankwar3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	private int x,y;
	private boolean good;
	public final static int XMobile = 5;
	public final static int YMobile = 5;
	public final static int XWIDTH = 40;		//̹�˵Ŀ�
	public final static int YHEIGHT = 40;		//̹�˵ĸ�
	
	private boolean bU=false, bR=false, bL=false, bD=false;
	enum Direction {l,lu,u,ru,r,rd,d,ld,stop}					//����һ�� ���� ��ö����		ö�ٵ���˼���� ���п���ȫ���оٳ���
	private Direction dir = Direction.stop;						//�Ƚ�������Ϊstopֹͣ	̹�˵ķ���dir
	private Direction ptdir = Direction.r;								//��Ͳ�ķ���dir
	
	MyFrame mf = null;
	Bullet bullet = null;
	
	public Tank(int x, int y, boolean good) {
		this.x = x;
		this.y = y;
		this.good = good;
	}
	
	public Tank(int x, int y, MyFrame mf, boolean good) {					//����д�Ϳ��Խ�fire�����ķ���ֵ���ݸ�TankClient�����
		this(x,y,good);
		this.mf = mf;
	}
	
	public void draw(Graphics g) {
		Color c= g.getColor();
		if(good) g.setColor(Color.red);
		if(!good) g.setColor(Color.white);
		g.fillOval(x, y, XWIDTH, YHEIGHT);
		g.setColor(c);
	
		switch(ptdir) {
			case l: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x, y+YHEIGHT/2) ; break;
			case lu: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x, y) ; break;
			case u:	g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x+XWIDTH/2, y) ; break;
			case ru: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x+XWIDTH, y) ; break;
			case r: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x+XWIDTH, y+YHEIGHT/2) ; break;
			case rd: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x+XWIDTH, y+YHEIGHT) ; break;
			case d: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x+XWIDTH/2, y+YHEIGHT) ; break;
			case ld: g.drawLine(x+XWIDTH/2, y+YHEIGHT/2, x, y+YHEIGHT) ; break;
		}
		
		move();
		
		if(x<0) x=0;
		if(y<30) y=30;
		if(x>mf.GAME_WIDTH - XWIDTH) x = mf.GAME_WIDTH - XWIDTH;
		if(y>mf.GAME_HEIGHT - YHEIGHT) y = mf.GAME_HEIGHT - YHEIGHT;
	}
	
	public void move() {
		switch(dir) {
			case l: x -= XMobile ; break;
			case lu: x -= XMobile; y -= YMobile ; break;
			case u:	y -= YMobile ; break;
			case ru: x += XMobile; y -= YMobile ; break;
			case r: x += XMobile ; break;
			case rd: x += XMobile; y += YMobile ; break;
			case d: y += YMobile ; break;
			case ld: x -= XMobile; y += YMobile ; break;
			case stop: ; break;
		}
		
		if(dir != Direction.stop) {					//û����Ļ���Ͳ�Ͳ���ı�
			this.ptdir = this.dir;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		switch(i) {
			case KeyEvent.VK_SPACE: fire(); break;			//���ӵ����ݵ�TankClient�����
			case KeyEvent.VK_UP: bU = true; break;
			case KeyEvent.VK_RIGHT: bR = true; break;
			case KeyEvent.VK_LEFT: bL = true; break;
			case KeyEvent.VK_DOWN: bD = true; break;
		}
		this.direct();
		
	}

	private void fire() {
		bullet = new Bullet(x+XWIDTH/2-Bullet.XWIDTH/2, y+YHEIGHT/2-Bullet.YHEIGHT/2, ptdir);
		mf.list.add(bullet);
	}

	public void keyReleased(KeyEvent e) {		//����̧���¼��ķ���
		int i = e.getKeyCode();
		switch(i) {
			case KeyEvent.VK_UP: bU = false; break;
			case KeyEvent.VK_RIGHT: bR = false; break;
			case KeyEvent.VK_LEFT: bL = false; break;
			case KeyEvent.VK_DOWN: bD = false; break;
		}
		this.direct();
		
	}
	
	public void direct() {
		if(bU && !bR && !bL && !bD) dir = Direction.u;
		else if(!bU && bR && !bL && !bD) dir = Direction.r;
		else if(!bU && !bR && bL && !bD) dir = Direction.l;
		else if(!bU && !bR && !bL && bD) dir = Direction.d;
		else if(bU && bR && !bL && !bD) dir = Direction.ru;
		else if(bU && !bR && bL && !bD) dir = Direction.lu;
		else if(!bU && bR && !bL && bD) dir = Direction.rd;
		else if(!bU && !bR && bL && bD) dir = Direction.ld;
		else if(!bU && !bR && !bL && !bD) dir = Direction.stop;
	}
	
}