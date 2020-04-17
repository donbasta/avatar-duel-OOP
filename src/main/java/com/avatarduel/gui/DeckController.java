package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    
    private Controller controller;
    
    public void setController(Controller controller) {
    	this.controller = controller;
    }
	
    @FXML
	void initialize() {
		deck1.setFill(Color.BROWN);
		deck2.setFill(Color.AQUAMARINE);
	}
	
	@FXML
	void drawCard(MouseEvent event) {
		String id = ((Node) event.getSource()).getId();
//		System.out.println(id);
		
		int player = -1;
		if(id.equals("deck1")) {
			player = 1;
		} else {
			player = 2;
		}
		controller.handleDrawCard(player);
		
//		try {
////			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cardtable.fxml"));
////			Parent root = loader.load();
////			CardController cardController = loader.<CardController>getController();
////			cardController.drawCard();
////			System.out.println(id);
//				} catch (Exception e) {

//		}

	}
	
	

}
