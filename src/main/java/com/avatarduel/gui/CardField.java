package com.avatarduel.gui;

import com.avatarduel.cards.Card;



import javafx.scene.Node;

/**
 * CardField is a custom class containing
 * all cards information in the field including
 * SkillCard and CharacterCard.
 *
 * @author 
 */
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

	public CardFieldViewer addSkillCard(Card c, Controller controller, int p) {
		for(Node child : skill.getChildren()) {
			CardFieldViewer cardField = (CardFieldViewer) child;
			if(!cardField.getAda()) {
				cardField.setCard(c);
				cardField.setAda(true);
				return cardField;
			}
		}
		return null;
	}

	public void removeSkill(CardViewer c, Controller controller, int p){
		this.skill.removeCard(c);
		this.skill.addCardToField(controller, p);
	}

	public void removeCharacter(CardViewer c, Controller controller, int p){
		this.character.removeCharacter(c, controller, p);
	}

	public int countCharacter(){
		int cnt = 0;
		for(Node child : character.getChildren()){
			CardFieldViewer cardField = (CardFieldViewer) child;
			if(cardField.getAda()){
				cnt++;
			}
		}
		return cnt;
	}
	
	
	
}
