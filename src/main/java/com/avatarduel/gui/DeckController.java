package com.avatarduel.gui;


import com.avatarduel.state.Player;
import com.avatarduel.state.Power;

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
    
    @FXML
    private VBox power1;
    
    @FXML
    private VBox power2;
    
    private Text[] numCardDeck;
    private VBox[] powerStat;
    
    private Controller controller;
    
    public void setController(Controller controller) {
    	this.controller = controller;
    }
	
    @FXML
	void initialize() {
		deck1.setFill(Color.BROWN);
		deck2.setFill(Color.AQUAMARINE);
		
		numCardDeck = new Text[3];
		numCardDeck[1] = numCardDeck1;
		numCardDeck[2] = numCardDeck2;
		
		powerStat = new VBox[3];
		powerStat[1] = power1;
		powerStat[2] = power2;
	}
	
	@FXML
	void drawCard(MouseEvent event) {
		String id = ((Node) event.getSource()).getId();
		
		int player = -1;
		if(id.equals("deck1")) {
			player = 1;
		} else {
			player = 2;
		}
		//kasih try catch buat nangkep exception tangan penuh
		controller.handleDrawCard(player);
		numCardDeck[player].setText("");
	}
	
	public void setPower(int p, Power power) {
		
		for(int i=0; i<4; i++) {
			Node child = powerStat[p].getChildren().get(i);
			Text text = (Text) child;
			if(i==0) {
				text.setText("WATER: " + Integer.toString(power.getWater()) + "/" + Integer.toString(power.getMaxWater()));
			} else if(i==1) {
				text.setText("EARTH: " + Integer.toString(power.getEarth()) + "/" + Integer.toString(power.getMaxEarth()));
			} else if(i==2) {
				text.setText("FIRE: " + Integer.toString(power.getFire()) + "/" + Integer.toString(power.getMaxFire()));
			} else if(i==3) {
				text.setText("AIR: " + Integer.toString(power.getAir()) + "/" + Integer.toString(power.getMaxAir()));
			}
		}
		
	}
	
	
}