package com.tictactoe;

public enum PlayerEnum {
	PLAYER_ONE(1),
	PLAYER_TWO(2);

	int val;
	
	PlayerEnum(int i) {
		val = i;
	}
	
	int getValue() {
		return val;
	}
	
	 public static PlayerEnum getPlayer(int i) {
		for(PlayerEnum player : PlayerEnum.values()) {
			if(player.getValue() == i) {
				return player;
			}
		}
		return null;
	}
}
