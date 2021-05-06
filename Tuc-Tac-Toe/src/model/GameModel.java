package model;

import control.GameController;
import view.GameBoard;

public class GameModel {
	PlayersCatalogue  playerCatalogue;
	String [] gamePlayers;		
	String[][] gameBoard;
	GameController gc;
 
	Boolean mover;
	int moves;
	
	public static final int Rows = 3;
    public static final int Cols = 3;
    
	/************************************* CONSTRUCTOR ****************************************/
	public GameModel(GameController gc) {
		this.gc=gc;
		gamePlayers = new String[2];
		gameBoard= null;
		playerCatalogue= new PlayersCatalogue();
		
		mover=false;
		moves=0;
	}
	
	/************************************** METHODS *********************************************/
	public void selectPlayer(String player, int pos) {
		if (pos<0 && pos>1)return;
		gamePlayers[pos]=player;		
	}
	
	
	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] !=null);
	}
	
	
	public void startGame() {
		gameBoard= new String[3][3];
	}
	
	public boolean inPlay() {
		return gameBoard !=null && moves <9;
	}
	
	public boolean NoPlay() {
		return !inPlay();
	}
	
	public int getMover() {
		return mover.compareTo(false);
	}
	
	
	public String[] getGamePlayers() {
		return gamePlayers;
	}
	

	public String[][] getGameBoard() {
		return gameBoard;
	}
	
	public void checkDimValidity(int row, int col) {
		if (row <0 || col < 0 || row > 2 || col >2) {
			throw new IndexOutOfBoundsException(row + ","+col +" is not a valid board cell");
		}
	}
	
	public void checkMoveValidity(int row, int col) {
		checkDimValidity(row, col);
		if (gameBoard[row][col]!=null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}
	
	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public PlayersCatalogue getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayersCatalogue playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}
	
	//Draws a X or a O on the right cell
	public void makeMove(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col]=getMoverMark();
		mover=!mover;
		moves++;
		
		if (getMoverMark() == "X") {
			GameBoard.xTurn();
		}
		else {
			GameBoard.oTurn();
		}
		
		checkIfGameEnded();
	}
	
	
	public String getMoverMark() {
		return mover? "X": "O";
	}
	
	public boolean XWon(String[][] gameBoard) {
        if(gameBoard[0][0]=="X" && gameBoard[0][1]=="X" && gameBoard[0][2]=="X") {
            return true;
        }
        else if(gameBoard[1][0]=="X" && gameBoard[1][1]=="X" && gameBoard[1][2]=="X") {
        	return true;
        }
        else if(gameBoard[2][0]=="X" && gameBoard[2][1]=="X" && gameBoard[2][2]=="X") {
        	return true;
        }
        else if(gameBoard[0][0]=="X" && gameBoard[1][0]=="X" && gameBoard[2][0]=="X") {
        	return true;
        }
        else if(gameBoard[0][1]=="X" && gameBoard[1][1]=="X" && gameBoard[1][2]=="X") {
        	return true;
        }
        else if(gameBoard[0][2]=="X" && gameBoard[1][2]=="X" && gameBoard[2][1]=="X") {
        	return true;
        }
        else if(gameBoard[0][2]=="X" && gameBoard[1][1]=="X" && gameBoard[2][0]=="X") {
        	return true;
        }
        else if(gameBoard[0][0]=="X" && gameBoard[1][1]=="X" && gameBoard[2][2]=="X") {
        	return true;
        }
        else
        	return false;
    }
	
	public boolean OWon(String[][] gameBoard) {
        if(gameBoard[0][0]=="O" && gameBoard[0][1]=="O" && gameBoard[0][2]=="O") {
            return true;
        }
        else if(gameBoard[1][0]=="O" && gameBoard[1][1]=="O" && gameBoard[1][2]=="O") {
        	return true;
        }
        else if(gameBoard[2][0]=="O" && gameBoard[2][1]=="O" && gameBoard[2][2]=="O") {
        	return true;
        }
        else if(gameBoard[0][0]=="O" && gameBoard[1][0]=="O" && gameBoard[2][0]=="O") {
        	return true;
        }
        else if(gameBoard[0][1]=="O" && gameBoard[1][1]=="O" && gameBoard[2][1]=="O") {
        	return true;
        }
        else if(gameBoard[0][2]=="O" && gameBoard[1][2]=="O" && gameBoard[2][2]=="O") {
        	return true;
        }
        else if(gameBoard[0][2]=="O" && gameBoard[1][1]=="O" && gameBoard[2][0]=="O") {
        	return true;
        }
        else if(gameBoard[0][0]=="O" && gameBoard[1][1]=="O" && gameBoard[2][2]=="O") {
        	return true;
        }
        else
        	return false;
    }
	
	//a method to check if the board is full
    public boolean isBoardFull(String[][] gameBoard) {
        for (int row = 0; row < Rows; row++) {
            for (int col = 0; col < Cols; col++) {
                if (gameBoard[row][col] == null) {
                    // if at least one cell on the board is not filled then the board is not full
                    return false;
                }
            }
        }
        return true;
    }
    
  //method to see who won
    public String GameResults(String[][] gameBoard) {
        //check if the board is not full
        
        if(!isBoardFull(gameBoard)) {
            //if none of the players won then the game is unfinished
            
            if (OWon(gameBoard)) {
                return "O";
            
            } else if (XWon(gameBoard)) {
                return "X";
            }
            else {
                return "Unfinished";
            }
        }
        //else if the board is full
        else{
            //if none of the players won then the game is a draw
            
            if (OWon(gameBoard)) {
                return "O";

            } else if (XWon(gameBoard)) {
                return "X";
            }
            else {
                return "Tie";
            }
        }
    }
    
    public void checkIfGameEnded() {
        
        
        if(GameResults(this.gameBoard)!="Unfinished") {
        
            //display the correct text
            
            if(GameResults(this.gameBoard) == "Tie") {
                GameBoard.textfield.setText("Tie");
            }
            else {
                
                GameBoard.textfield.setText(GameResults(this.gameBoard)+" Wins");        
            }
            }
        
    }


	
	public String getPlayerStats(String player) {
		StringBuilder sb = new StringBuilder("");
		sb.append(player).append("\n\n\n");
		sb.append("Total:").append("\t").append(4).append("\n");
		sb.append("Won:").append("\t").append("75%").append("\n");
		sb.append("Lost:").append("\t").append("25%").append("\n");
		return sb.toString();			
	}
		
}
