package tankwar6;

import java.awt.*;
import java.util.Random;

public class Blood {
	private int x,y;
	public static final int height = 15;	//血块的高和宽
	public static final int weight = 15;
	private boolean live = true;
	//血的运动轨迹，由position中各个点组成
	int[][] position = {{130,230},{400,350},{250,400},{220,430}};
	private static Random  rad = new Random();
	int step = 0;
	
	MyFrame mf = null;
	
	public Blood(MyFrame mf) {
		x = position[0][0];
		y = position[0][1];
		this.mf = mf;
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Rectangle pezhuang() {
		return new Rectangle(x,y,height,weight);
	}
	
	public void draw(Graphics g) {
		if(!this.isLive()) return;					//注意这步很重要，没他的话就无法吃血
		
		Color c = g.getColor();
		g.setColor(Color.pink);
		g.fillRect(x, y, weight, height);
		g.setColor(c);
		
		step ++;
		if(step >= position.length) {
			step =0;
		}		
		x = position[step][0];
		y = position[step][1];
	}
	
}
