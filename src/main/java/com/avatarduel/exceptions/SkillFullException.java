package com.avatarduel.exceptions;

public class SkillFullException extends Exception{
	
	String message;
	
	public SkillFullException() {
		this.message = "Slot kartu skill penuh";
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
