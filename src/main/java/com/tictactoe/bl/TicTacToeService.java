package com.tictactoe.bl;

import com.tictactoe.Player;
import com.tictactoe.TicTacToe;

public class TicTacToeService {
	
	TicTacToe tacTacToe = null;
	
	public TicTacToe getNewGame() {
		if(tacTacToe == null) {
			tacTacToe = new TicTacToe();
		}
		return tacTacToe;
	}

	public TicTacToe playMove(Player player, int x, int y) {
		tacTacToe.playMove(player, x, y);
		return tacTacToe;
	}
	
	public TicTacToe getStatus() {
		return tacTacToe;
	}
}
