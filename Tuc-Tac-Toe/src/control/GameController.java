package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.GameModel;
import model.Player;
import model.PlayersCatalogue;
import view.GameBoard;
import view.MainAreaPanel;
import view.MainWindow;

public class GameController extends WindowAdapter {
	MainWindow view;
	GameModel model;
	GameBoard gboard;
	
	Player[] PlCatalogue;
	int numOfPlayers = 4;
	
	public GameController() {
		//this.gboard = new GameBoard(null);
		
		//GameModel model = new GameModel(null);
	}
	
	@Override
	public void windowClosing(WindowEvent event) {
		quit();
	}
	
	
	public void start() {
		this.view= new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.view.setVisible(true);
	}
	
	public void quit() {		
		System.out.println("bye bye...");		
		System.exit(0);
	}
	
	
	public void selectPlayer(String p, int pos) {
		this.model.selectPlayer(p, pos);	
		System.out.println("Player " + pos + " set to " + p);
		this.view.getRightPanel().getStartBtn().setEnabled(model.ready());	
		this.view.getLeftPanel().getStartBtn().setEnabled(model.ready());
	}
	
	public void startGame() {
		this.model.setGameBoard(new String[3][3]);
		this.view.getRightPanel().getStartBtn().setEnabled(false);
		this.view.getLeftPanel().getStartBtn().setEnabled(false);
		this.view.getMainPanel().showCard(MainAreaPanel.BOARD);
		this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
		this.view.getRightPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
	}
	
	//Adds a Player
  	public void addPlayer () {
  		int z=-1;
  		String newName = null;
  		
  		while(z<0) {
  			String addPlayerWindow = JOptionPane.showInputDialog("Enter the name of the new player: ");       

  			if(addPlayerWindow.length()>0) {
  				z++;
  				newName = addPlayerWindow;
  				System.out.println("Name entered.");
  			
  			}else System.out.println("Name has not entered");
  			
  		}
  		
  		Player p = new Player(newName);
  		PlCatalogue[numOfPlayers] = p;
  		numOfPlayers++;
  		
  		System.out.println("Player added");
  	}
	
	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}

	
}
