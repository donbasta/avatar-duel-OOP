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
	
	private int tes;

	
	@FXML
	void initialize() {
		System.out.println("this controller");
		tes = 0;
	}
	
	@FXML 
	public void drawCard() {
		tes++;
		System.out.println("lol" + tes);
	}
	
	@FXML
	void viewCard(MouseEvent event) {
//		String id = ((Node) event.getSource()).getId();
//		System.out.println(id);
		System.out.println("hiyaa");
		event.consume();
	}
	
}
