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

	private Controller controller;
	
	private CardTable[] player;
	
//	private int tes;
    
    public void setController(Controller controller) {
    	this.controller = controller;
    }
	
	@FXML
	void initialize() {
		player = new CardTable[3];
//		tes = 0;
		player[1] = player1;
		player[2] = player2;

	}
	
	public void addCard(int p, Card c) {
//		tes++;
//		System.out.println("lol" + tes);
		player[p].addCard(c, controller);
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
