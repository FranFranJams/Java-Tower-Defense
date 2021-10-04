package ui;

import java.awt.Color;
import java.awt.Graphics;

public class BottomBar {

	private int x, y, width, height;
	
	public BottomBar(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(226,114,91));
		g.fillRect(x, y, width, height);
	}
	
}
