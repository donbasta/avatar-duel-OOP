package com.avatarduel.gui;

import com.avatarduel.cards.Card;

import javafx.scene.Node;

public class CardField {
	
	private CardTable character;
	private CardTable skill;
	
	public CardField(CardTable character, CardTable skill) {
		this.character = character;
		this.skill = skill;
	}
	
	public void addCard(Card c, Controller controller, int p) {
		for(Node child : character.getChildren()) {
			CardFieldViewer cardField = (CardFieldViewer) child;
			if(!cardField.getAda()) {
				cardField.setCard(c);
				cardField.setAda(true);
				break;
			}
		}
	}

	public void removeCharacter(CardViewer c, Controller controller, int p){
		this.character.removeCharacter(c, controller, p);
	}

	
	
	
}
