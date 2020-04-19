package com.avatarduel.exceptions;

public class NotEnoughPowerException extends Exception{
	
	String message;
	
	public NotEnoughPowerException() {
		this.message = "Power tidak cukup";
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
}
