package model;

public class Player {
	String name;
	int numOfGames;
	int numOfWins;
	int numOfLosses;
	
	
	/***************************************** CONSTRUCTOR 1 ***********************************************/
	public Player(String name, int numOfGames, int wins, int losses) {
		super();
		this.name = name;
		this.numOfLosses =losses;
		this.numOfWins = wins;
		this.numOfGames = numOfGames;
	}
	
	/***************************************** CONSTRUCTOR 2 ***********************************************/
	public Player(String newName) {
		this.name = name;
	}

	/******************************************** METHODS ***************************************************/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfGames() {
		return numOfGames;
	}

	public void setNumOfGames(int numOfGames) {
		this.numOfGames = numOfGames;
	}

	public int getWins() {
		return numOfWins;
	}

	public void setWins(int wins) {
		this.numOfWins = wins;
	}

	public int getLosses() {
		return numOfLosses;
	}

	public void setLosses(int losses) {
		this.numOfLosses = losses;
	}

}
