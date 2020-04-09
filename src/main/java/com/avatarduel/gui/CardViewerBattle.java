package com.avatarduel.gui;

import com.avatarduel.cards.Card;

public class CardViewerBattle extends CardViewer {
	
	protected int pos; //1 jika attack, 0 jika defense, -1 undefined
	
	public CardViewerBattle() {
		super();
		this.pos = -1;
	}
	
	public CardViewerBattle(boolean isUp, boolean isAda, Card card, int pos) {
		super(isUp, isAda, card);
		this.pos = pos;
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getPos() {
		return this.pos;
	}

}
