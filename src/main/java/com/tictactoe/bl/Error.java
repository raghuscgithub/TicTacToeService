package com.tictactoe.bl;

public class Error {
	String errorMessage = null;
	
	public Error(String msg) {
		errorMessage = msg;
	}

	public String getMessage() {
		return errorMessage;
	}

	public void setMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
