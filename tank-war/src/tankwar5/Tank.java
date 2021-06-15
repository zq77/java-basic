package tankwar5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;

public class Tank {
	private int x,y;
	private boolean good;					//判断是哪一方的坦克
	private boolean live = true;				//坦克是否活着
	//private Rectangle rectangle;
	public final static int XMobile = 7;
	public final static int YMobile = 7;
	public final static int XWIDTH = 40;		//坦克的宽
	public final static int YHEIGHT = 40;		//坦克的高
	
	private boolean bU=false, bR=false, bL=false, bD=false;
	enum Direction {l,lu,u,ru,r,rd,d,ld,stop}					//定义一个 方向 的枚举类		枚举的意思就是 所有可能全部列举出来
	private Direction dir = Direction.stop;						//先将方向定义为stop停止	坦克的方向dir
	private Direction ptdir = Direction.r;								//炮筒的方向dir
	
	MyFrame mf = null;
	Bullet bullet = null;
	
	private static Random  rad = new Random();							//使坦克随机运动
	int step = rad.nextInt(12)+3;						//使坦克可以多移动几步再变换方向
	
	int oldX, oldY;						//定义坦克上一步的位置，用于判断坦克撞墙
	
	public Tank(int x, int y, boolean good) {
		this.x = x;
		this.y = y;
		this.good = good;
	}
	
	public Tank(int x, int y, MyFrame mf, boolean good, Direction dir) {					//这样写就可以将fire（）的返回值传递给TankClient这个类
		this(x,y,good);
		this.dir = dir;
		this.mf = mf;
	}
	
	public boolean meetWall(Wall w) {
		if(this.live && this.pezhuang().intersects(w.pezhuang())) {
			stay();
			return true;
		}
		return false;
	}
	
	public void stay() {
		this.x = oldX;
		this.y = oldY;
	}
	
	public Rectangle pezhuang() {
		return new Rectangle(x,y,XWIDTH,YHEIGHT);
	}
	
	public boolean isLive() {
		return live;
	}

	public boolean isGood() {
		return good;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		if(!this.isLive()) return;
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
		
		this.oldX = x;
		this.oldY = y;
		//移动之前把坦克位置记录下来
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
		
		if(!good) {
			Direction[] dirs = Direction.values();		//转换成数组
			if(step == 0) {
				step = rad.nextInt(12)+3;				//使坦克可以多移动几步再变换方向
				int t = rad.nextInt(dirs.length);
				dir = dirs[t];
			}
			step --;
			
			if(rad.nextInt(37)>33) this.fire();
		}
		
		if(dir != Direction.stop) {					//没这个的话炮筒就不会改变
			this.ptdir = this.dir;
		}
	}

	private void fire() {				//坦克   开火    方法
			if(this.live) {
				bullet = new Bullet(x+XWIDTH/2-Bullet.XWIDTH/2, y+YHEIGHT/2-Bullet.YHEIGHT/2, ptdir,mf,this.good);
			    mf.list.add(bullet);
			}
	}
	
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		switch(i) {
			case KeyEvent.VK_SPACE: fire(); break;			//将子弹传递到TankClient这个类
			//case KeyEvent.VK_ENTER: 
			case KeyEvent.VK_UP: bU = true; break;
			case KeyEvent.VK_RIGHT: bR = true; break;
			case KeyEvent.VK_LEFT: bL = true; break;
			case KeyEvent.VK_DOWN: bD = true; break;
		}
		this.direct();
		
	}

	public void keyReleased(KeyEvent e) {		//键盘抬起事件的方法
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
