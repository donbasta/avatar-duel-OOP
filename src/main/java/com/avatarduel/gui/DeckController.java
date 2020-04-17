package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class DeckController extends VBox {
	
    @FXML
    private Rectangle deck1;

    @FXML
    private Rectangle deck2;
    
    @FXML
    private Text numCardDeck1;

    @FXML
    private Text numCardDeck2;
	
    @FXML
	void initialize() {
		deck1.setFill(Color.BROWN);
		deck2.setFill(Color.AQUAMARINE);
	}
	
	@FXML
	void drawCard(MouseEvent event) {
		String id = ((Node) event.getSource()).getId();
		System.out.println(id);
//		deck1.setFill(Color.WHITE);
		event.consume();
	}

}
