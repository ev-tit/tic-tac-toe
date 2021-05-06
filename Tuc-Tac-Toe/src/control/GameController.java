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
	//PlayersCatalogue plCat;
	
	
	
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
	
	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}

	public void addPlayer(String name, Player p) {
		//plCat.addPlayer(p);
		
	}
		
/*		
	//Find the player who won
	public void findWinner() {
		if(checkForWinner()==true) {
			
			// reverse the player marks
			// because after we put x and we win, the game changes it to o
			// but x is the winner
			  if(model.getMoverMark() == "X") {
				  model.getMoverMark().equals("O");
			  	}
			  else model.getMoverMark().equals("X");
				
			JOptionPane pane = new JOptionPane();
			int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over." + model.getMoverMark() + "wins. Would you like to play again? ", "Game Over.", JOptionPane.YES_NO_OPTION);             
			
			  if(dialogResult == JOptionPane.YES_OPTION) {
				  resetTheButtons();
			  }else System.exit(0);
		
		}else if(checkForFull()) {
			JOptionPane pane = new JOptionPane();
		    int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw. Play again?", "Game Over.", JOptionPane.YES_NO_OPTION);
		    
		       if(dialogResult == JOptionPane.YES_OPTION)
		    	   resetTheButtons();
		       else System.exit(0);
		}
		
	}
	
	//methods used to reset the buttons so you can play again 
	private void resetTheButtons() {
		for(int i=0; i<9; i++) {
			model.getMoverMark().equals("X");
			gboard.cells[i].setToolTipText(" ");
			
		}
	}
	
*/		
	
}
