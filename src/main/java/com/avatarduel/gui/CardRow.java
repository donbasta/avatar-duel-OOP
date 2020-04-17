package com.avatarduel.gui;

import com.avatarduel.cards.*;

import javafx.scene.layout.HBox;

public class CardRow extends HBox {
	
	public void addCard(Card card) {
		CardViewer newCard = new CardViewer(card);
		this.getChildren().add(newCard);
	}
	
//	public void removeCard(Card card, int player) {
//		for (Node child : stackWrapp.getChildren()) {
//		    ImageView imgView = (ImageView) child;
//		    
//		}
//	}
	
	 
}