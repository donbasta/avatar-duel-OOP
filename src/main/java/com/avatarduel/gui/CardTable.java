package com.avatarduel.gui;

import com.avatarduel.cards.*;

import javafx.scene.layout.HBox;

public class CardTable extends HBox {
	
	public void addCardToHand(Card card, Controller controller, int p) {
		this.getChildren().add(new CardHandViewer(card, controller, p));
	}
	
	public void addCardToField(Controller controller, int p) {
		this.getChildren().add(new CardFieldViewer(controller, p));
	}

	public void removeCard(CardViewer c){
		this.getChildren().remove(c);
	}
	 
}