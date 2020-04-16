package com.avatarduel.exceptions;

public class NotEnoughPowerException extends Exception{
	
	String message;
	
	public NotEnoughPowerException() {
		this.message = "Power elemen tidak cukup";
	}
	
	public String toString() {
		return this.message;
	}

}
