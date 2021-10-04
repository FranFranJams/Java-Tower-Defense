package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import managers.TileManager;
import ui.BottomBar;
import ui.FirstButton;
import helpz.LevelBuilder;

import static main.GameStates.*;

public class Playing extends GameScene implements SceneMethods{

	private int[][] lvl;
	private TileManager tileManager;
	private FirstButton bMenu;
	
	private BottomBar bottomBar;
	
	public Playing(Game game) {
		super(game);
		
		// The Level
		initButtons();
		lvl = LevelBuilder.getLevelData();
		tileManager = new TileManager();
		bottomBar = new BottomBar(0, 640, 640, 100);
		
		// Tilemanager
	}
	

	private void initButtons() {
		bMenu = new FirstButton("Menu", 2, 2, 100, 30);

	}
	

	@Override
	public void render(Graphics g) {
		
		for (int y = 0; y < lvl.length; y++) {
			for (int x = 0; x < lvl[y].length; x++) {
				int id = lvl[y][x];
				g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
			}
		}
		
		drawButtons(g);
		bottomBar.draw(g);
		//g.setColor(new Colour(108,45,199));
		//g.fillRect(0, 0, 640, 640);
	}


	private void drawButtons(Graphics g) {
		bMenu.draw(g);
		

	}

	
	@Override
	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			SetGameState(MENU);

	}

	@Override
	public void mouseMoved(int x, int y) {
		bMenu.setMouseHover(false);
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseHover(true);

	}

	@Override
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);

	}

	@Override
	public void mouseReleased(int x, int y) {
		bMenu.resetBooleans();

	}

}
