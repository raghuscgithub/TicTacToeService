package com.tictactoe.bl;

import java.util.HashMap;
import java.util.Map;

import com.tictactoe.PlayerEnum;
import com.tictactoe.TicTacToe;
import com.tictactoe.Result;

public class TicTacToeService {
	
	TicTacToe tacTacToe = null;
	HashMap<Result, Integer> metrics = new HashMap<Result, Integer>();
	
	public TicTacToeService() {
		metrics.put(Result.PLAYER_ONE, 0);
		metrics.put(Result.PLAYER_TWO, 0);
		metrics.put(Result.DRAW, 0);
	}
	
	public TicTacToe getNewGame() {
		if(tacTacToe == null) {
			tacTacToe = new TicTacToe();
		}
		return tacTacToe;
	}

	public TicTacToe playMove(PlayerEnum player, int x, int y) {
		Result result = tacTacToe.playMove(player, x, y);
		if(result != null) {
			Integer currVal =  metrics.get(result);
			metrics.put(result, currVal + 1 );
		}
		tacTacToe.printBoard();
		return tacTacToe;
	}
	
	public TicTacToe getStatus() {
		return tacTacToe;
	}

	public Map getMetrics() {
		return metrics;
	}
}