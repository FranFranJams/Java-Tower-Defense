package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FirstButton {

	private int x, y, width, height;
	private String text;
	private Rectangle bounds;
	private boolean mouseHover, mousePressed;
	
	
	public FirstButton(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		initBounds();
	}
	
	
	private void initBounds() {
		this.bounds = new Rectangle(x, y, width, height);
	}
	
	
	public void draw(Graphics g) {
		
		// Body
		drawBody(g);

		// Border
		drawBorder(g);
		
		// Text
		drawText(g);
	}	
	
	
	private void drawBorder(Graphics g) {
		if(mousePressed) {
			g.setColor(new Color(108,45,199));
			g.drawRect(x, y, width, height);
			g.drawRect(x + 1, y + 1, width - 2, height - 2);
			g.drawRect(x + 2, y + 2, width - 4, height - 4);
		}else {
			g.setColor(new Color(108,45,199));
			g.drawRect(x, y, width, height);
		}
	}


	
	private void drawBody(Graphics g) {
		if(mouseHover)
			g.setColor(Color.GRAY);
		else
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
	}

	
	public void resetBooleans() {
		this.mouseHover = false;
		this.mousePressed = false;
	}
	
	
	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
	
	public void setMouseHover(boolean mouseHover) {
		this.mouseHover = mouseHover;
	}

	private void drawText(Graphics g) {
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		
		g.drawString(text, x - w / 2 + width / 2, y + h / 2 + height / 2);
		
		
	}


	public Rectangle getBounds() {
		return bounds;
	}
	
	
	
}
