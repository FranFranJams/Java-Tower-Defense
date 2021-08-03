package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

public class Game extends JFrame implements Runnable {
	
	private GameScreen gameScreen;

	
	private int updates;
	private long lastTimeUPS;
	
	private Thread gameThread;
	
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	private MyMouseListener myMouseListener;
	private KeyboardListener keyboardListener;
	
	private Render render;

	
	//Use Ctrl + Space to show auto complete!
	
	public Game() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Tower Defense");
		
		render = new Render(this);
		gameScreen = new GameScreen(this);
		add(gameScreen);

		pack();
		setVisible(true);
	}
	
	
	private void initInputs() {
		myMouseListener = new MyMouseListener();
		keyboardListener = new KeyboardListener();
		
		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();
	}
	

	
	private void start() {
		gameThread = new Thread(this) {};
		
		gameThread.start();
	}



	
	private void updateGame() {

		//System.out.println("Game Updated");
		
	}

	public static void main(String[] args) {
				
		Game game = new Game();
		game.initInputs();
		game.start();
	}
	
	@Override
	public void run() {
	

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis(); 
		
		
		int frames = 0;
		int updates = 0;
		
		long now;
		
		while(true) {
			now = System.nanoTime();
			// Render
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
	}		
			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
	}
			// FPS + UPS Check
			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS " + frames + " | UPS " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
		}
	}
}
