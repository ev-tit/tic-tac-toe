package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Player;

public class DemoWritingiToFiles {

	public static void main(String[] args) throws IOException {
		
		Player p1 = new Player("Maria", 1, 2, 3);
		Player p2 = new Player("Angela", 3, 8, 3);
		Player p3 = new Player("Evangelia", 1, 5, 9);
		
		Player [] playersArray = new Player[3];
		playersArray[0] = p1;
		playersArray[1] = p2;
		playersArray[2] = p3;
		
		for( int i = 0; i < playersArray.length; i++) {
			String outputText = playersArray[i].getName() + "|" + playersArray[i].getLosses() + "|" + playersArray[i].getWins() + "|" + playersArray[i].getNumOfGames();
			
			saveToFile("playersList.txt", outputText, true);
		}

	}

	private static void saveToFile(String fileName, String text, boolean append) throws IOException {
		File file1 = new File(fileName);
		
		FileWriter fw = new FileWriter(file1, append);
		
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(text);
		
		pw.close();
	}

}
