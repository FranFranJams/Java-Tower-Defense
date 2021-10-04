package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

public class GameScreen extends JPanel {

	private Game game;
	
	private Dimension size;
	
	private MyMouseListener myMouseListener;
	private KeyboardListener keyboardListener;
	
	
	public GameScreen(Game game) {
		this.game = game;
		
		setPanelSize();

	}
	

	public void initInputs() {
		myMouseListener = new MyMouseListener(game);
		keyboardListener = new KeyboardListener();
		
		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();
	}
	

	
	private void setPanelSize() {
		size = new Dimension(640,720);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.getRender().render(g);
	// purple: g.setColor(new Color(108,45,199));

		}
	}

	

	

