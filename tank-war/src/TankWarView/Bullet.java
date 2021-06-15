package TankWarView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	子弹类
 * @author z
 *
 */
public class Bullet {
	
//	Toolkit是一个工具包,	Toolkit.getDefaultToolkit()就可以拿到当前系统默认的工具包
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	public int x,y;
	boolean live = true;
	private boolean good;					//判断是哪一方的子弹

	public final static int XMobile = 10;
	public final static int YMobile = 10;
	public final static int XWIDTH = 10;		//子弹的宽
	public final static int YHEIGHT = 10;		//子弹的高
	Direction dir;			//方向
	MyFrame mf = null;
	
	//定义成静态变量因为在Bullet类的fighttank(Tank t)方法中new一个Explosion就会从硬盘上调用一次Image，定义成静态的就能直接调用	
		private static Image[] ima = null;
		
		private static Map<String, Image> image = new HashMap();	//定义一个容器将图片装进去
		
	//静态区,	这样写的好处是更灵活		用static封装一段代码，这段代码保证在第一次loader到内存的时候就执行	最适合给一些变量做初始化
		static {
			ima = new Image[] {				
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileL.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileLU.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileLD.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileD.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileR.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileRD.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileLURU.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("image/missileU.gif")),

			};
			
			image.put("l", ima[0]);
			image.put("lu", ima[1]);
			image.put("ld", ima[2]);
			image.put("d", ima[3]);
			image.put("r", ima[4]);
			image.put("rd", ima[5]);
			image.put("ru", ima[6]);
			image.put("u", ima[7]);
							
		}
	
	public Bullet(int x,int y,Direction ptdir,MyFrame mf, boolean good) {
		this.x = x;
		this.y = y;
		this.dir = ptdir;
		this.mf = mf;
		this.good = good;
	}

	public boolean meetWall(Wall w) {					//判断子弹是否碰到墙
		if(this.live && this.pezhuang().intersects(w.pezhuang())) {
			this.live = false;
			return true;
		}
		return false;
	}
	
	public boolean fighttank(Tank t) {					//判断子弹是否打中坦克，  		这很重要
		if(this.good != t.isGood() &&this.pezhuang().intersects(t.pezhuang()) && t.isLive()) {
			if(t.isGood() && t.getLife()>0) {
				t.setLife(t.getLife()-1);
			} else {
				t.setLive(false);
			}			
			this.live = false;				//子弹阵亡
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
	
	public boolean isLive() {						//判断子弹是否活着
		return live;
	}

	public void draw(Graphics g) {
		
		switch(dir) {
			case l: g.drawImage(image.get("l"), x, y, null) ; break;
			case lu: g.drawImage(image.get("lu"), x, y, null)  ; break;
			case u:	g.drawImage(image.get("u"), x, y, null) ; break;
			case ru: g.drawImage(image.get("ru"), x, y, null) ; break;
			case r: g.drawImage(image.get("r"), x, y, null) ; break;
			case rd: g.drawImage(image.get("rd"), x, y, null) ; break;
			case d: g.drawImage(image.get("d"), x, y, null) ; break;
			case ld: g.drawImage(image.get("ld"), x, y, null) ; break;
		}
			
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
