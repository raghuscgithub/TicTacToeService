package com.tictactoe;

public enum Player {
	PLAYER_ONE(1),
	PLAYER_TWO(2);

	int val;
	
	Player(int i) {
		val = i;
	}
	
	int getValue() {
		return val;
	}
	
	 public static Player getPlayer(int i) {
		for(Player player : Player.values()) {
			if(player.getValue() == i) {
				return player;
			}
		}
		return null;
	}
}
