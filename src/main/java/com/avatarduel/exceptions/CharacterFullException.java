package com.avatarduel.exceptions;

public class CharacterFullException extends Exception{
	
	String message;
	
	public CharacterFullException() {
		this.message = "Slot kartu karakter penuh";
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
