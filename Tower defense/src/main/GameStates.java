package main;

public enum GameStates {
	
	PLAYING, MENU, SETTINGS;
	
	public static GameStates gameState = MENU;
	
	public static void SetGameStates(GameStates states) {
		gameState = State;
	}

}
