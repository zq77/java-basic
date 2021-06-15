package tankwar5;

import java.awt.*;

public class Explosion {			//这是一个爆炸类
	public int x, y;
	public int[] r = {1,4,5,8,12,20,38,49,41,20,7};
	private boolean live = true;
	public static int i = 0;
	MyFrame mf = null;
	
	Explosion(int x, int y, MyFrame mf) {
		this.x = x;
		this.y = y;
		this.mf = mf;
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		if(!live) return;
		if(i == r.length) {
			i = 0;
			this.setLive(false);
		}
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval(x, y, r[i], r[i]);
		g.setColor(c);
		
		i++;
	}
}
