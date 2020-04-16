package com.avatarduel.gui;

import com.avatarduel.cards.*;
import com.avatarduel.model.Element;

public class CardViewer {
	
	private boolean isUp;
	private boolean isAda;
	private Card card;
	
	public CardViewer() {
		this.isUp = false;
		this.isAda = false;
		this.card = new LandCard("","",Element.AIR,"");
	}
	
	public CardViewer(boolean isUp, boolean isAda, Card card){
		this.isUp = isUp;
		this.isAda = isAda;
		this.card = card;
	}
	
	public void setUp(boolean b) {
		this.isUp = b;
	}
	
	public void setAda(boolean b) {
		this.isAda = b;
	}
	
	public void setImagePath(Card card) {
		this.card = card;
	}
	
	public boolean getUp() {
		return this.isUp;
	}
	
	public boolean getAda() {
		return this.isAda;
	}
	
	public Card getCard() {
		return this.card;
	}

}
