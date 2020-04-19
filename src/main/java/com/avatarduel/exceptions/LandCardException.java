package com.avatarduel.exceptions;

public class LandCardException extends Exception {
	
	String message;
	
	public LandCardException() {
		this.message = "Failed to put land card in field, already put";
	}
	
	public String toString() {
		return this.message;
	}

}
