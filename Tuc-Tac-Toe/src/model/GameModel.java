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
		
		if(gResult(this.gameBoard) != "Undone") {
			throw new IllegalArgumentException("Game Ended");
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
		
		gEnd();
	}
	
	public String getMoverMark() {
		return mover? "X": "O";
	}
	
	//Check if X won
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
        else if(gameBoard[0][1]=="X" && gameBoard[1][1]=="X" && gameBoard[2][1]=="X") {
        	return true;
        }
        else if(gameBoard[0][2]=="X" && gameBoard[1][2]=="X" && gameBoard[2][2]=="X") {
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
	
	//Check if O won
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
	
	//Check if the game board is full
    public boolean FullBoard(String[][] gameBoard) {
        for (int row = 0; row < 3 ; row++) {
            for (int col = 0; col < 3 ; col++) {
                if (gameBoard[row][col] == null) {
                    // if at least one cell on the board is not filled then the board is not full
                    return false;
                }
            }
        }
        return true;
    }
    
    
    //Check who player won
    public String gResult(String[][] gameBoard) {
        //if the board isn't full
    	if(!FullBoard(gameBoard)) {
            if (OWon(gameBoard)) {
                return "O"; 
            } else if (XWon(gameBoard)) {
                return "X";
            }
            else {
                return "Undone";	//If none of the players won
            }
        }
        //else if the board is full
        else{
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
    
    //Shows the result in the label
    public void gEnd() { 
        if(gResult(this.gameBoard)!="Undone") {
            if(gResult(this.gameBoard) == "Tie") {
                GameBoard.textfield.setText("Tie");
            }
            else {
                GameBoard.textfield.setText(gResult(this.gameBoard) + " Wins");   
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
