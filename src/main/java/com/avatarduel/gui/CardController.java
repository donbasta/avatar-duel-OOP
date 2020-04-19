package com.avatarduel.gui;

import com.avatarduel.cards.Card;

import com.avatarduel.cards.LandCard;
import com.avatarduel.model.Element;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * CardController is FXML controller for the cards.
 *
 * @author 
 */
public class CardController extends GridPane implements NotificationController {
	
	@FXML private CardTable player1;
	
	@FXML private CardTable player2;
	
	@FXML private CardTable fieldSkill1;

	@FXML private CardTable fieldSkill2;
	
	@FXML private CardTable fieldChar1;
	
	@FXML private CardTable fieldChar2;
	
	public CardTable[] fieldSkill, fieldChar;

	private Controller controller;
	
	private CardTable[] hand;
	private CardField[] field;
	public static CardViewer clickedCard;
	
    public void setController(Controller controller) {
    	this.controller = controller;
    }
	
    /**
     * FXML Controller init method
     */
	@FXML
	void initialize() {
		hand = new CardTable[3];
		hand[1] = player1;
		hand[2] = player2;
		
		fieldSkill = new CardTable[3];
		fieldSkill[1] = fieldSkill1;
		fieldSkill[2] = fieldSkill2;
		
		fieldChar = new CardTable[3];
		fieldChar[1] = fieldChar1;
		fieldChar[2] = fieldChar2;
		
		field = new CardField[3];
		field[1] = new CardField(fieldChar1, fieldSkill1);
		field[2] = new CardField(fieldChar2, fieldSkill2);
	}
	
    /**
     * Adds card to field
     * @param p player index
     * @param c card to be added
     */
	public void addCardToField(int p, Card c) {
		field[p].addCard(c, controller, p);
	}
	
    /**
     * Adds SkillCard to field
     * @param p player index
     * @param c card to be added
     */
	public CardFieldViewer addSkillToField(int p, Card c){
		return field[p].addSkillCard(c, controller, p);
	}
	
    /**
     * Adds card to hand
     * @param p player index
     * @param c card to be added
     */
	public void addCardToHand(int p, Card c) {
		hand[p].addCardToHand(c, controller, p);
	}

	public void hide(int p){
		if(p == 1){
			hand[2].hide();
		} else {
			hand[1].hide();
		}
	}

	public void switchHide(){
		hand[1].hide();
		hand[2].hide();
	}

	public void resetAttacked(int p){
		field[p].resetAttacked();
	}
	
    /**
     * Removes card from hand
     * @param p player index
     * @param c card to be added
     */
	public void removeCard(CardViewer c, int p){
		hand[p].removeCard(c);
	}
	
    /**
     * Removes a SkillCard from a CardViewer
     * @param c CardViewer containing SkillCard to be removed
     */
	public void removeSkill(CardViewer c){
		int owner = c.getOwner();
		field[owner].removeSkill(c, controller, owner);
	}
	
    /**
     * Removes a CharacterCard from a CardViewer
     * @param c CardViewer containing CharacterCard to be removed
     */
	public void removeCharacter(CardViewer c){
		int owner = c.getOwner();
		field[owner].removeCharacter(c, controller, owner);
	}
	
    /**
     * Checks if there is a CharacterCard in the field
     */
	public Boolean characterNotEmpty(){
		return (field[1].countCharacter() > 0 || field[2].countCharacter() > 0);
	}
	
	@FXML
	void viewCard(MouseEvent event) {
		String id = event.getPickResult().getIntersectedNode().getId(); 
		/* idnya berbentuk macam2 */
		System.out.println(id);
		Card card = new LandCard("LOL", "LOL", Element.WATER, "src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png");
		controller.updateView(card);
		event.consume();
	}
	
	public CardField getField(int player) {
		return this.field[player];
	}
	
}
