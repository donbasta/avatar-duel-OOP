package com.avatarduel.gui;

import com.avatarduel.cards.*;

import javafx.scene.layout.HBox;

import javafx.scene.Node;

/**
 * CardTable is a custom FXML
 * component which contains a row
 * of cards
 *
 * @author 
 */
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

	public void removeCharacter(CardViewer c, Controller controller, int p){
		if(this.getChildren().contains(c)){
			this.getChildren().remove(c);
			this.addCardToField(controller, p);
		} 
	}

	public void hide(){
		for(Node child : this.getChildren()){
			CardHandViewer a = (CardHandViewer) child;
			a.change();
		}
	}
	 
}