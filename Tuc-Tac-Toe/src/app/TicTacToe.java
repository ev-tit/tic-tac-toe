package app;

import control.GameController;


public class TicTacToe {
	
	
	public static void main(String[] args) {		
		GameController gc = new GameController();
		gc.start();
		
		/*
		public Game create() {
			Game newGame = createGameObject();
			if(newGame != null)
				gamesCreated++;
			return newGame;
		}
		*/
		
	}
}
