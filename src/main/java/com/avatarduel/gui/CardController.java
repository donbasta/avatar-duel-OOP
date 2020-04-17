package com.avatarduel.gui;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.LandCard;
import com.avatarduel.cards.SkillCard;
import com.avatarduel.model.Element;
import com.avatarduel.state.Player;
import com.avatarduel.gui.*;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

public class CardController extends GridPane {
	
	@FXML private CardTable player1;
	
	@FXML private CardTable player2;
	
	@FXML private CardTable fieldSkill1;

	@FXML private CardTable fieldSkill2;
	
	@FXML private CardTable fieldChar1;
	
	@FXML private CardTable fieldChar2;

	private Controller controller;
	
	private CardTable[] hand;
	private CardField[] field;
	public static CardViewer clickedCard;
	
    public void setController(Controller controller) {
    	this.controller = controller;
    }
	
	@FXML
	void initialize() {
		hand = new CardTable[3];
		hand[1] = player1;
		hand[2] = player2;
		
		for(int i=1; i<=6; i++) {
			fieldChar1.addCardToField(controller, 1);
			fieldChar2.addCardToField(controller, 2);
			fieldSkill1.addCardToField(controller, 1);
			fieldSkill2.addCardToField(controller, 2);
		}
		
		field = new CardField[3];
		field[1] = new CardField(fieldChar1, fieldSkill1);
		field[2] = new CardField(fieldChar2, fieldSkill2);
	}
	
	public void addCardToField(int p, Card c) {
		field[p].addCard(c, controller, p);
	}
	
	public void addCardToHand(int p, Card c) {
		hand[p].addCardToHand(c, controller, p);
	}

	public void removeCard(CardViewer c, int p){
		hand[p].removeCard(c);
	}
	
	@FXML
	void viewCard(MouseEvent event) {
//		String id = ((Node) event.getSource()).getId();
//		System.out.println(id);
		String id = event.getPickResult().getIntersectedNode().getId(); 
		/* idnya berbentuk macam2 */
		System.out.println(id);
		Card card = new LandCard("LOL", "LOL", Element.WATER, "src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png");
		controller.updateView(card);
		event.consume();
	}
	
}
