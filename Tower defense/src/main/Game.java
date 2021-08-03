package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {
	
	private GameScreen gameScreen;
	
	private BufferedImage img;
	
	
	private int updates;
	private long lastTimeUPS;
	
	private long lastUpdate;
	private double timePerUpdate;
	
	private Thread gameThread;
	
	//Use Ctrl + Space to show auto complete!
	
	public Game() {

		
		timePerUpdate = 1000000000.0 / 60.0;
		
		importImg();
		
		
		setSize(640,640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Tower Defense");
		
		
		gameScreen = new GameScreen(img);
		add(gameScreen);
		setVisible(true);
	}
	
	
	private void importImg() {
		
		InputStream is = getClass().getResourceAsStream("/spriteatlas.png");
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	private void start() {
		gameThread = new Thread(this) {};
		
		gameThread.start();
	}

	private void loopGame() {
 
		}
			
	private void callUPS() {
		if (System.currentTimeMillis() - lastTimeUPS >=1000) {
			System.out.println("UPS: " + updates);
			updates = 0;
			lastTimeUPS = System.currentTimeMillis();
		}
	}
	

	private void updateGame() {
		updates++;
		lastUpdate = System.nanoTime();
		//System.out.println("Game Updated");
		
	}

	public static void main(String[] args) {
				
		Game game = new Game();
		game.start();
	}
	
	@Override
	public void run() {
	

		double timePerFrame;
		long lastFrame = System.nanoTime();
		
		//long lastUpdate;
		//double timePerUpdate;
		
		timePerFrame = 1000000000.0 / 100.0;
		//timePerUpdate = 1000000000.0 / 60.0;
	
		while(true) {
			if (System.nanoTime() - lastFrame >= timePerFrame) {
				lastFrame = System.nanoTime();
				repaint();		
	}		

			//Render
		
		if (System.nanoTime() - lastUpdate >= timePerUpdate) {
				updateGame();
				
				callUPS();
			}
		}			

		
		
	//Update
		
	//Checking FPS + UPS
		
	}
	
	
	
	
}
