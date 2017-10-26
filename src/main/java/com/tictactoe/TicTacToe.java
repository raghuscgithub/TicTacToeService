package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	int boardSize = 3;
	Integer[][] board = new Integer[boardSize][boardSize];
	Integer[] moves = new Integer[boardSize * boardSize];
	int totalMoves = 0;
	Result result = null;
	PlayStatus playStatus = PlayStatus.NEW;
	
	public TicTacToe() {
		initializeBoard();
		setPlayStatus(PlayStatus.IN_PROGRESS);
	}

	private void printBoard() {
		for(int i=0; i<boardSize; i++) {
			System.out.println();
			for(int j=0; j<boardSize; j++) {
				System.out.print(" " + board[i][j]);
			}
		}
	}

	private void setPlayStatus(PlayStatus status) {
		playStatus = status;
	}

	public Result getResult() {
		return result;
	}

	public PlayStatus getPlayStatus() {
		return playStatus;
	}

	public void playMove(Player player, Integer x, Integer y) {
		if(!isGameComplete() && totalMoves != boardSize * boardSize) {
			if(board[x][y] == 0) {
				board[x][y] = player.getValue();
				totalMoves++;
				//printBoard();
			}
			
			if(isGameComplete()) {
				playStatus = PlayStatus.COMPLETE;
				result = Result.PLAYER_ONE;
				return;
			}
		}

		if(isGameComplete() == false && totalMoves == boardSize * boardSize) {
			result = Result.DRAW;
			playStatus = PlayStatus.COMPLETE;
		}
	}

	private boolean isGameComplete() {
	   //Row Complete
	   for (int i=0; i<boardSize; i++)
	    {
	        if (board[i][0] == board[i][1] &&
	            board[i][1] == board[i][2] && 
	            board[i][0] != 0)
	            return true;
	    }
		// Column Complete
		for (int i=0; i<boardSize; i++)
	    {
	        if (board[0][i] == board[1][i] &&
	            board[1][i] == board[2][i] && 
	            board[0][i] != 0) {
	        	 return true;
	        }
	    }
		// L Diagonal Complete
	    if (board[0][0] == board[1][1] &&
	            board[1][1] == board[2][2] && 
	            board[0][0] != 0) {
	    	 return(true);
	    }        
	    //R Diagonal Complete    
	    if (board[0][2] == board[1][1] &&
	            board[1][1] == board[2][0] &&
	             board[0][2] != 0) {
	    	 return true;
	    }  
		return false;
	}

	private void initializeBoard() {
		for(int i=0; i<boardSize; i++) {
			for(int j=0;j<boardSize; j++) {
				board[i][j]=0;
			}
		}
		for(int i=0; i< boardSize*boardSize; i++) {
			moves[i]=0;
		}
	}
}
