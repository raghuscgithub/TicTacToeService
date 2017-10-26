package com.tictactoe;

public enum Result {
	PLAYER_ONE(1),
	PLAYER_TWO(2),
	DRAW(3);

	int val;
	
	Result(int i) {
		val = i;
	}
	
	int getValue() {
		return val;
	}
	
	 public static Result getResult(int i) {
		for(Result result : Result.values()) {
			if(result.getValue() == i) {
				return result;
			}
		}
		return null;
	}
}
