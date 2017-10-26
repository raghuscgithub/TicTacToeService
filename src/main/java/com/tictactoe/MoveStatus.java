package com.tictactoe;

public enum MoveStatus {
	VALID(1),
	INVALID(2);
	int val;
	
	MoveStatus(int i) {
		val = i;
	}
	
	int getValue() {
		return val;
	}

	 public static MoveStatus getMoveStatus(int i) {
		for(MoveStatus moveStatus : MoveStatus.values()) {
			if(moveStatus.getValue() == i) {
				return moveStatus;
			}
		}
		return null;
	}
}
