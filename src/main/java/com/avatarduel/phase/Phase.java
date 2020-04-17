package com.avatarduel.phase;

import java.util.HashMap;

public abstract class Phase {
	protected int turn;
	protected HashMap<String, Boolean> flag;

	public Boolean resetPower;
	public Boolean canDraw;
	public Boolean drawBtn;
	public Boolean mainBtn;
	public Boolean battleBtn;
	public Boolean endturnBtn;

	public Phase(int a){
		this.turn = a;
	}

	public int getTurn(){
		return this.turn;
	}

}
