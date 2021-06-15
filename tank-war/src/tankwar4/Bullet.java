package tankwar4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Bullet {
	public int x,y;
	boolean live = true;

	public final static int XMobile = 10;
	public final static int YMobile = 10;
	public final static int XWIDTH = 10;		//子弹的宽
	public final static int YHEIGHT = 10;		//子弹的高
	Tank.Direction dir;			//方向
	
	public Bullet(int x,int y,Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	
	public boolean fighttank(Tank t) {					//判断子弹是否打中坦克，  		这很重要
		if(this.pezhuang().intersects(t.pezhuang()) && t.isLive()) {
			t.setLive(false);
			live = false;
			return true;
		}
		return false;
	}
	
	public Rectangle pezhuang() {
		return new Rectangle(x,y,XWIDTH,YHEIGHT);
	}
	
	public boolean isLive() {						//判断子弹是否活着
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
