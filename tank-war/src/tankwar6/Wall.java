package tankwar6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//定义一个墙
public class Wall {
	int Wall_X, Wall_Y, height, weight;		//墙的  坐标, 尺寸
	MyFrame mf = null;
	
	public Wall(int Wall_X, int Wall_Y, int height, int weight, MyFrame mf) {
		this.Wall_X = Wall_X;
		this.Wall_Y = Wall_Y;
		this.height = height;
		this.weight = weight;
		this.mf = mf;
	}
	
	public Rectangle pezhuang() {
		return new Rectangle(Wall_X, Wall_Y, weight, height);
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fill3DRect(Wall_X, Wall_Y, weight, height, true);
		g.setColor(c);
	}
}
