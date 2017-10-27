package com.tictactoe.bl;

import com.tictactoe.PlayerEnum;
import com.tictactoe.TicTacToe;

public class TicTacToeService {
	
	TicTacToe tacTacToe = null;
	
	public TicTacToe getNewGame() {
		if(tacTacToe == null) {
			tacTacToe = new TicTacToe();
		}
		return tacTacToe;
	}

	public TicTacToe playMove(PlayerEnum player, int x, int y) {
		tacTacToe.playMove(player, x, y);
		tacTacToe.printBoard();
		return tacTacToe;
	}
	
	public TicTacToe getStatus() {
		return tacTacToe;
	}
}
