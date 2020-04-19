package com.avatarduel.gui;


import com.avatarduel.state.Power;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
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
    private Text hpText1;
    
    @FXML
    private Text hpText2;
    
    @FXML
    private ProgressBar hpBar1;
    
    @FXML
    private ProgressBar hpBar2;
    
    @FXML
    private Text currentTurnText;
    
    @FXML
    private Text numCardDeck1;

    @FXML
    private Text numCardDeck2;
    
    @FXML
    private VBox power1;
    
    @FXML
    private VBox power2;
    
    private ProgressBar[] hpBar;
    private Text[] numCardDeck, hpText;
    private VBox[] powerStat;
//    private DoubleProperty[] healthUpdater;
    
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
		
		hpText = new Text[3];
		hpText[1] = hpText1;
		hpText[2] = hpText2;
		
		hpBar = new ProgressBar[3];
		hpBar[1] = hpBar1;
		hpBar[2] = hpBar2;
		hpBar[1].setStyle("-fx-accent: red;");
		hpBar[2].setStyle("-fx-accent: blue;");
		
//		healthUpdater = new DoubleProperty[3];
//		healthUpdater[1] = new SimpleDoubleProperty(.0);
//		healthUpdater[2] = new SimpleDoubleProperty(.0);
		
//		for(int i=1; i<=2; i++) {
//			playerHealth[i].progressProperty().bind(healthUpdater[i]);
//		}

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
		controller.handleDrawCard(player);
	}
	
	public void setNumCardDeck(int player, int numRemainingCard) {
		numCardDeck[player].setText(Integer.toString(numRemainingCard));
	}
	
	public void setHpText(int player, int curHp) {
		hpText[player].setText("HP: "+Integer.toString(curHp)+"/80");
	}
	
	public void setProgressBarHp(int player, int curHp) {
		System.out.println("lololol");
//		healthUpdater[player].set(((double) curHp)/80.00);
//		playerHealth[player].progressProperty().bind(healthUpdater[player]);
		hpBar[player].setProgress(((double) curHp)/80.00);
	}
	
	public void setCurrentTurn(int player) {
		currentTurnText.setText("It's player " + Integer.toString(player) + " turn!");
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