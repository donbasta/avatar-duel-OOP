package com.avatarduel.gui;

import com.avatarduel.cards.*;

import javafx.scene.layout.HBox;

public class CardTable extends HBox {
	
	public void addCard(Card card, Controller controller, int p) {
		CardViewer newCard = new CardViewer(card, controller, p);
		this.getChildren().add(newCard);
	}

	public void removeCard(CardViewer c){
		this.getChildren().remove(c);
	}
	
//	public void removeCard(Card card, int player) {
//		for (Node child : stackWrapp.getChildren()) {
//		    ImageView imgView = (ImageView) child;
//		    
//		}
//	}
	
	 
}