package com.avatarduel.exceptions;

public class HandFullException extends Exception {
	
	String message;
	
	public HandFullException() {
		this.message = "Hand is full";
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
}
