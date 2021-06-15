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
 * 	�ӵ���
 * @author z
 *
 */
public class Bullet {
	
//	Toolkit��һ�����߰�,	Toolkit.getDefaultToolkit()�Ϳ����õ���ǰϵͳĬ�ϵĹ��߰�
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	public int x,y;
	boolean live = true;
	private boolean good;					//�ж�����һ�����ӵ�

	public final static int XMobile = 10;
	public final static int YMobile = 10;
	public final static int XWIDTH = 10;		//�ӵ��Ŀ�
	public final static int YHEIGHT = 10;		//�ӵ��ĸ�
	Direction dir;			//����
	MyFrame mf = null;
	
	//����ɾ�̬������Ϊ��Bullet���fighttank(Tank t)������newһ��Explosion�ͻ��Ӳ���ϵ���һ��Image������ɾ�̬�ľ���ֱ�ӵ���	
		private static Image[] ima = null;
		
		private static Map<String, Image> image = new HashMap();	//����һ��������ͼƬװ��ȥ
		
	//��̬��,	����д�ĺô��Ǹ����		��static��װһ�δ��룬��δ��뱣֤�ڵ�һ��loader���ڴ��ʱ���ִ��	���ʺϸ�һЩ��������ʼ��
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

	public boolean meetWall(Wall w) {					//�ж��ӵ��Ƿ�����ǽ
		if(this.live && this.pezhuang().intersects(w.pezhuang())) {
			this.live = false;
			return true;
		}
		return false;
	}
	
	public boolean fighttank(Tank t) {					//�ж��ӵ��Ƿ����̹�ˣ�  		�����Ҫ
		if(this.good != t.isGood() &&this.pezhuang().intersects(t.pezhuang()) && t.isLive()) {
			if(t.isGood() && t.getLife()>0) {
				t.setLife(t.getLife()-1);
			} else {
				t.setLive(false);
			}			
			this.live = false;				//�ӵ�����
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
