package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;
import ui.FirstButton;
import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {
	
	private BufferedImage img;
	
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private Random random;
	
	private FirstButton bPlaying, bSettings, bQuit;
	
	public Menu(Game game) {
		super(game);
		random = new Random();
		importImg();
		loadSprites();
		initButtons();
	}

	
	
	private void initButtons() {
		// Sets variables & defines what the buttons are & where they should go
		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 150;
		int yOffset = 100;
		
		bPlaying = new FirstButton("Play", x, y, w, h);
		bSettings = new FirstButton("Settings", x, y + yOffset, w, h);
		bQuit = new FirstButton("Quit", x, y + yOffset * 2, w, h);
		
	}

	@Override
	public void render(Graphics g) {
		// Literally renders stuff
		
		drawButtons(g);
}	
	
	// Literally draws the buttons
		private void drawButtons(Graphics g) {
		bPlaying.draw(g);
		bSettings.draw(g);
		bQuit.draw(g);
	}

		private void importImg() {
	// Self explanatory ^ Imports an image (spritesheet in this case) from a given resource 
			InputStream is = getClass().getResourceAsStream("/spriteatlas.png");
				
			try {
					img = ImageIO.read(is);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			}
			
	// Loads a SubImage from a SpriteSheet based on X, Y, W & H 
		private void loadSprites() {
			
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++) {
					sprites.add(img.getSubimage(x*32, y*32, 32, 32));
				}
			}
			
		}

		
		private int getRandInt() {
			return random.nextInt(100);
		}



		@Override
		public void mouseClicked(int x, int y) {
			
			if (bPlaying.getBounds().contains(x, y)) {
				SetGameState(PLAYING);
			} else if (bSettings.getBounds().contains(x, y)) {
				SetGameState(SETTINGS);
			} else if (bQuit.getBounds().contains(x, y))
				System.exit(0);
		}



		@Override
		public void mouseMoved(int x, int y) {
			bPlaying.setMouseHover(false);
			bSettings.setMouseHover(false);
			bQuit.setMouseHover(false);

			if (bPlaying.getBounds().contains(x, y)) {
				bPlaying.setMouseHover(true);
			} else if (bSettings.getBounds().contains(x, y)) {
				bSettings.setMouseHover(true);
			} else if (bQuit.getBounds().contains(x, y)) {
				bQuit.setMouseHover(true);
			}
		}


		@Override
		public void mousePressed(int x, int y) {

			if (bPlaying.getBounds().contains(x, y)) {
				bPlaying.setMousePressed(true);
			} else if (bSettings.getBounds().contains(x, y)) {
				bSettings.setMousePressed(true);
			} else if (bQuit.getBounds().contains(x, y)) {
				bQuit.setMousePressed(true);
			}
		}



		@Override
		public void mouseReleased(int x, int y) {
			resetButtons();
		}



		private void resetButtons() {
			bPlaying.resetBooleans();
			bSettings.resetBooleans();
			bQuit.resetBooleans();
			
		}
		
		
}
	


