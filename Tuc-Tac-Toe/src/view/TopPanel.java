package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.GameController;
import model.GameModel;
import model.PlayersCatalogue;

public class TopPanel extends GamePanel{	
	JButton quitBtn;
	JButton doneBtn;
	JButton addPlayerBtn;
	PlayersCatalogue plCatalogue;
	
	public TopPanel(GameController gc) {
		super(gc);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		
		quitBtn = new JButton("Quit App");	
		quitBtn.setPreferredSize(new Dimension(100, 40));
		quitBtn.addActionListener((e)->{this.gc.quit();});		
		
		doneBtn = new JButton("Done");		
		doneBtn.setPreferredSize(new Dimension(100, 40));		
		doneBtn.setEnabled(false);
		doneBtn.addActionListener((e)->{System.out.println("done pressed");});
		
		addPlayerBtn = new JButton("Add Player");
		addPlayerBtn.setPreferredSize(new Dimension(100, 40));
		addPlayerBtn.setEnabled(true);
		addPlayerBtn.addActionListener((e)->{this.gc.addPlayer();});		
		
		add(addPlayerBtn);
		add(quitBtn);
		add(doneBtn);				
	} 

	public JButton getQuitBtn() {
		return quitBtn;
	}

	public JButton getDoneBtn() {
		return doneBtn;
	}	
	
	public JButton getAddPlayerBtn() {
		return addPlayerBtn;
	}	
	
	
}
