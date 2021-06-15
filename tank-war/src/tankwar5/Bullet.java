package tankwar5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

public class Bullet {
	public int x,y;
	boolean live = true;
	private boolean good;					//�ж�����һ�����ӵ�

	public final static int XMobile = 10;
	public final static int YMobile = 10;
	public final static int XWIDTH = 10;		//�ӵ��Ŀ�
	public final static int YHEIGHT = 10;		//�ӵ��ĸ�
	Tank.Direction dir;			//����
	MyFrame mf = null;
	
	public Bullet(int x,int y,Tank.Direction ptdir,MyFrame mf, boolean good) {
		this.x = x;
		this.y = y;
		this.dir = ptdir;
		this.mf = mf;
		this.good = good;
	}

	public boolean meetWall(Wall w) {					//�ж��ӵ��Ƿ�����ǽ
		if(this.live && this.pezhuang().intersects(w.pezhuang())) {
			this.live = false;
			return true;
		}
		return false;
	}
	
	public boolean fighttank(Tank t) {					//�ж��ӵ��Ƿ����̹�ˣ�  		�����Ҫ
		if(this.good != t.isGood() &&this.pezhuang().intersects(t.pezhuang()) && t.isLive()) {
			t.setLive(false);
			live = false;
			Explosion explosion = new Explosion(x, y, mf);
			mf.list1.add(explosion);
			return true;
		}
		return false;
	}
	
	public boolean fighttanks(List<Tank> l) {
		for(int i=0; i<l.size(); i++) {
			if(this.fighttank(l.get(i))) {
				return true;
			}
		}	
		return false;
	}
	
	public Rectangle pezhuang() {
		return new Rectangle(x,y,XWIDTH,YHEIGHT);
	}
	
	public boolean isLive() {						//�ж��ӵ��Ƿ����
		return live;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, XWIDTH, YHEIGHT);
		g.setColor(c);
		
		move();
		
		if(x<0 || y<0 || x>MyFrame.GAME_WIDTH || y>MyFrame.GAME_HEIGHT) {
			live = false;
		}
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
	}
	
}
