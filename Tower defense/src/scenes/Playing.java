package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import managers.TileManager;
import helpz.LevelBuilder;

public class Playing extends GameScene implements SceneMethods{

	private int[][] lvl;
	private TileManager tileManager;
	
	
	public Playing(Game game) {
		super(game);
		
		// The Level
		lvl = LevelBuilder.getLevelData();
		tileManager = new TileManager();
		
		// Tilemanager
	}

	@Override
	public void render(Graphics g) {
		
		for (int y = 0; y < lvl.length; y++) {
			for (int x = 0; x < lvl[y].length; x++) {
				int id = lvl[y][x];
				g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
			}
		}
		
		//g.setColor(new Color(108,45,199));
		//g.fillRect(0, 0, 640, 640);
	}

}
