package model;

public class PlayersCatalogue {
	private String[] players;
	
	private Player[] PlCatalogue;
	private int numOfPlayers;
	
	/************************************* CONSTRUCTOR *************************************************/
	public PlayersCatalogue() {
		players = new String[4];
		players[0]="Vasilis";
		players[1]="Nektarios";
		players[2]="Yannis";
		players[3]="Eleni";		
		
		
		this.numOfPlayers = 4;
		
		PlCatalogue = new Player[4];
		PlCatalogue[0] = new Player("Vasilis", 1, 2, 3);
		PlCatalogue[1] = new Player("Nektarios", 5, 7, 1);
		PlCatalogue[2] = new Player("Yannis", 4, 5, 8);
		PlCatalogue[3] = new Player("Eleni", 2, 4, 3);
		
	}
	
	
	/************************************** METHODS ****************************************************/
	public String getPlayer(int i) {
		if (i<0 || i>4) {
			return null;
		}
		return players[i];
	}
	
	
	public String[] getPlayers() {
		return players;
	}


	public Player[] getPlCatalogue() {
		return PlCatalogue;
	}


	public void setPlCatalogue(Player[] plCatalogue) {
		PlCatalogue = plCatalogue;
	}


	public int getNumOfPlayers() {
		return numOfPlayers;
	}


	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	
	/*public void addPlayer () {
		//JOptionPane, ask fo name 
		
		Player p = new Player(name);
		
		PlCatalogue[numOfPlayers] = p;
		numOfPlayers++;
	}*/
	
}
