package main;

public enum GameStates {
	PLAYING, MENU, PAUSE, GAMEOVER, SHOP, SETTINGS;
	
	public static GameStates gameState = MENU;
	
	public void setGameState(GameStates gameState) {
		this.gameState = gameState;
	}
}
