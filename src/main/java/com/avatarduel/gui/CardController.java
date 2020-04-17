package com.avatarduel.gui;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.SkillCard;
import com.avatarduel.model.Element;
import com.avatarduel.state.Player;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CardController extends GridPane {
	
	@FXML private CardRow player1;
	
	@FXML private CardRow player2;
	
	private CardRow[] player;
	
//	private int tes;
	
    private Controller controller;
    
    public void setController(Controller controller) {
    	this.controller = controller;
    }
	
	@FXML
	void initialize() {
		player = new CardRow[3];
//		tes = 0;
		player[1] = player1;
		player[2] = player2;
	}
	
	public void addCard(int p, Card c) {
//		tes++;
//		System.out.println("lol" + tes);
		player[p].addCard(c);
	}
	
	@FXML
	void viewCard(MouseEvent event) {
//		String id = ((Node) event.getSource()).getId();
//		System.out.println(id);
		event.consume();
	}
	
}
