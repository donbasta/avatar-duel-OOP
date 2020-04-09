package com.avatarduel.exceptions;

public class EmptyCellException extends Exception{

	String message;
	
	public EmptyCellException() {
		this.message = "Tidak ada kartu di sini";
	}
	
	public String toString() {
		return this.message;
	}
	
}
