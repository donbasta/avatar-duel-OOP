package com.avatarduel.gui;

import javafx.scene.paint.Color;

import java.util.Collections;

import com.avatarduel.cards.Card;
import com.avatarduel.model.Element;
import com.avatarduel.state.Decks;
import com.avatarduel.state.Player;
import com.avatarduel.state.State;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

	@FXML
    private Pane mainPane;

    @FXML
    private Text cardViewName;

    @FXML
    private Text cardViewId;

    @FXML
    private ImageView cardViewImage;
    
    @FXML
    private Text cardViewDescription;

    @FXML
    private Rectangle cardBattleA9;

    @FXML
    private Text cardBattleA9Text;

    @FXML
    private Rectangle cardBattleA10;

    @FXML
    private Text cardBattleA10Text;

    @FXML
    private Rectangle cardBattleA11;

    @FXML
    private Text cardBattleA11Text;

    @FXML
    private Rectangle cardBattleA12;

    @FXML
    private Text cardBattleA12Text;

    @FXML
    private Rectangle cardBattleA13;

    @FXML
    private Text cardBattleA13Text;

    @FXML
    private Rectangle cardBattleA14;

    @FXML
    private Text cardBattleA14Text;

    @FXML
    private Rectangle cardBattleA15;

    @FXML
    private Text cardBattleA15Text;

    @FXML
    private Rectangle cardBattleA16;

    @FXML
    private Text cardBattleA16Text;

    @FXML
    private Rectangle cardBattleB9;

    @FXML
    private Text cardBattleB9Text;

    @FXML
    private Rectangle cardBattleB10;

    @FXML
    private Text cardBattleB10Text;

    @FXML
    private Rectangle cardBattleB11;

    @FXML
    private Text cardBattleB11Text;

    @FXML
    private Rectangle cardBattleB12;

    @FXML
    private Text cardBattleB12Text;

    @FXML
    private Rectangle cardBattleB13;

    @FXML
    private Text cardBattleB13Text;

    @FXML
    private Rectangle cardBattleB14;

    @FXML
    private Text cardBattleB14Text;

    @FXML
    private Rectangle cardBattleB15;

    @FXML
    private Text cardBattleB15Text;

    @FXML
    private Rectangle cardBattleB16;

    @FXML
    private Text cardBattleB16Text;

    @FXML
    private Rectangle cardBattleB1;

    @FXML
    private Text cardBattleB1Text;

    @FXML
    private Rectangle cardBattleB2;

    @FXML
    private Text cardBattleB2Text;

    @FXML
    private Rectangle cardBattleB3;

    @FXML
    private Text cardBattleB3Text;

    @FXML
    private Rectangle cardBattleB4;

    @FXML
    private Text cardBattleB4Text;

    @FXML
    private Rectangle cardBattleB5;

    @FXML
    private Text cardBattleB5Text;

    @FXML
    private Rectangle cardBattleB6;

    @FXML
    private Text cardBattleB6Text;

    @FXML
    private Rectangle cardBattleB7;

    @FXML
    private Text cardBattleB7Text;

    @FXML
    private Rectangle cardBattleB8;

    @FXML
    private Text cardBattleB8Text;

    @FXML
    private Rectangle cardDrawB1;

    @FXML
    private Text cardDrawB1Text;

    @FXML
    private Rectangle cardDrawB2;

    @FXML
    private Text cardDrawB2Text;

    @FXML
    private Rectangle cardDrawB3;

    @FXML
    private Text cardDrawB3Text;

    @FXML
    private Rectangle cardDrawB4;

    @FXML
    private Text cardDrawB4Text;

    @FXML
    private Rectangle cardDrawB5;

    @FXML
    private Text cardDrawB5Text;

    @FXML
    private Rectangle cardDrawB6;

    @FXML
    private Text cardDrawB6Text;

    @FXML
    private Rectangle cardDrawB7;

    @FXML
    private Text cardDrawB7Text;

    @FXML
    private Rectangle cardBattleA1;

    @FXML
    private Text cardBattleA1Text;

    @FXML
    private Rectangle cardBattleA2;

    @FXML
    private Text cardBattleA2Text;

    @FXML
    private Rectangle cardBattleA3;

    @FXML
    private Text cardBattleA3Text;

    @FXML
    private Rectangle cardBattleA4;

    @FXML
    private Text cardBattleA4Text;

    @FXML
    private Rectangle cardBattleA5;

    @FXML
    private Text cardBattleA5Text;

    @FXML
    private Rectangle cardBattleA6;

    @FXML
    private Text cardBattleA6Text;

    @FXML
    private Rectangle cardBattleA7;

    @FXML
    private Text cardBattleA7Text;

    @FXML
    private Rectangle cardBattleA8;

    @FXML
    private Text cardBattleA8Text;

    @FXML
    private Rectangle cardDrawA1;

    @FXML
    private Text cardDrawA1Text;

    @FXML
    private Rectangle cardDrawA2;

    @FXML
    private Text cardDrawA2Text;

    @FXML
    private Rectangle cardDrawA3;

    @FXML
    private Text cardDrawA3Text;

    @FXML
    private Rectangle cardDrawA4;

    @FXML
    private Text cardDrawA4Text;

    @FXML
    private Rectangle cardDrawA5;

    @FXML
    private Text cardDrawA5Text;

    @FXML
    private Rectangle cardDrawA6;

    @FXML
    private Text cardDrawA6Text;

    @FXML
    private Rectangle cardDrawA7;

    @FXML
    private Text cardDrawA7Text;

    @FXML
    private Rectangle deck1;

    @FXML
    private Rectangle deck2;
    
    private Rectangle[] cardDrawA;
    private Rectangle[] cardDrawB;
    private Rectangle[] cardBattleA;
    private Rectangle[] cardBattleB;
    private Text[] cardDrawAText;
    private Text[] cardDrawBText;
    private Text[] cardBattleAText;
    private Text[] cardBattleBText;
    private CardViewer[] objectCardDrawA;
    private CardViewer[] objectCardDrawB;
    private CardViewer[] objectCardBattleA;
    private CardViewer[] objectCardBattleB;
    
    private Player hojun;
    private Player qila;
    private State state;
    
    public void setPlay(Player pa, Player pb, State st) {
    	hojun = pa;
    	qila = pb;
    	state = st;
    }

    @FXML
    public void initialize() {
    	
    	System.out.println("test cuy"); //debug
    	Scene scene = mainPane.getScene();
   
    	cardDrawA = new Rectangle[8];
    	cardDrawA[1] = cardDrawA1;
    	cardDrawA[2] = cardDrawA2;
    	cardDrawA[3] = cardDrawA3;
    	cardDrawA[4] = cardDrawA4;
    	cardDrawA[5] = cardDrawA5;
    	cardDrawA[6] = cardDrawA6;
    	cardDrawA[7] = cardDrawA7;
    	
    	cardBattleA = new Rectangle[17];
    	cardBattleA[1] = cardBattleA1;
    	cardBattleA[2] = cardBattleA2;
    	cardBattleA[3] = cardBattleA3;
    	cardBattleA[4] = cardBattleA4;
    	cardBattleA[5] = cardBattleA5;
    	cardBattleA[6] = cardBattleA6;
    	cardBattleA[7] = cardBattleA7;
    	cardBattleA[8] = cardBattleA8;
    	cardBattleA[9] = cardBattleA9;
    	cardBattleA[10] = cardBattleA10;
    	cardBattleA[11] = cardBattleA11;
    	cardBattleA[12] = cardBattleA12;
    	cardBattleA[13] = cardBattleA13;
    	cardBattleA[14] = cardBattleA14;
    	cardBattleA[15] = cardBattleA15;
    	cardBattleA[16] = cardBattleA16;
    	
    	cardDrawAText = new Text[8];
    	cardDrawAText[1] = cardDrawA1Text;
    	cardDrawAText[2] = cardDrawA2Text;
    	cardDrawAText[3] = cardDrawA3Text;
    	cardDrawAText[4] = cardDrawA4Text;
    	cardDrawAText[5] = cardDrawA5Text;
    	cardDrawAText[6] = cardDrawA6Text;
    	cardDrawAText[7] = cardDrawA7Text;
    	
    	cardBattleAText = new Text[17];
    	cardBattleAText[1] = cardBattleA1Text;
    	cardBattleAText[2] = cardBattleA2Text;
    	cardBattleAText[3] = cardBattleA3Text;
    	cardBattleAText[4] = cardBattleA4Text;
    	cardBattleAText[5] = cardBattleA5Text;
    	cardBattleAText[6] = cardBattleA6Text;
    	cardBattleAText[7] = cardBattleA7Text;
    	cardBattleAText[8] = cardBattleA8Text;
    	cardBattleAText[9] = cardBattleA9Text;
    	cardBattleAText[10] = cardBattleA10Text;
    	cardBattleAText[11] = cardBattleA11Text;
    	cardBattleAText[12] = cardBattleA12Text;
    	cardBattleAText[13] = cardBattleA13Text;
    	cardBattleAText[14] = cardBattleA14Text;
    	cardBattleAText[15] = cardBattleA15Text;
    	cardBattleAText[16] = cardBattleA16Text;
    	
    	cardDrawB = new Rectangle[8];
    	cardDrawB[1] = cardDrawB1;
    	cardDrawB[2] = cardDrawB2;
    	cardDrawB[3] = cardDrawB3;
    	cardDrawB[4] = cardDrawB4;
    	cardDrawB[5] = cardDrawB5;
    	cardDrawB[6] = cardDrawB6;
    	cardDrawB[7] = cardDrawB7;
    	
    	cardBattleB = new Rectangle[17];
    	cardBattleB[1] = cardBattleB1;
    	cardBattleB[2] = cardBattleB2;
    	cardBattleB[3] = cardBattleB3;
    	cardBattleB[4] = cardBattleB4;
    	cardBattleB[5] = cardBattleB5;
    	cardBattleB[6] = cardBattleB6;
    	cardBattleB[7] = cardBattleB7;
    	cardBattleB[8] = cardBattleB8;
    	cardBattleB[9] = cardBattleB9;
    	cardBattleB[10] = cardBattleB10;
    	cardBattleB[11] = cardBattleB11;
    	cardBattleB[12] = cardBattleB12;
    	cardBattleB[13] = cardBattleB13;
    	cardBattleB[14] = cardBattleB14;
    	cardBattleB[15] = cardBattleB15;
    	cardBattleB[16] = cardBattleB16;
    	
    	cardDrawBText = new Text[8];
    	cardDrawBText[1] = cardDrawB1Text;
    	cardDrawBText[2] = cardDrawB2Text;
    	cardDrawBText[3] = cardDrawB3Text;
    	cardDrawBText[4] = cardDrawB4Text;
    	cardDrawBText[5] = cardDrawB5Text;
    	cardDrawBText[6] = cardDrawB6Text;
    	cardDrawBText[7] = cardDrawB7Text;
    	
    	cardBattleBText = new Text[17];
    	cardBattleBText[1] = cardBattleB1Text;
    	cardBattleBText[2] = cardBattleB2Text;
    	cardBattleBText[3] = cardBattleB3Text;
    	cardBattleBText[4] = cardBattleB4Text;
    	cardBattleBText[5] = cardBattleB5Text;
    	cardBattleBText[6] = cardBattleB6Text;
    	cardBattleBText[7] = cardBattleB7Text;
    	cardBattleBText[8] = cardBattleB8Text;
    	cardBattleBText[9] = cardBattleB8Text;
    	cardBattleBText[10] = cardBattleB10Text;
    	cardBattleBText[11] = cardBattleB11Text;
    	cardBattleBText[12] = cardBattleB12Text;
    	cardBattleBText[13] = cardBattleB13Text;
    	cardBattleBText[14] = cardBattleB14Text;
    	cardBattleBText[15] = cardBattleB15Text;
    	cardBattleBText[16] = cardBattleB16Text;
    	
    	objectCardDrawA = new CardViewer[8];
    	for(int i=1; i<8; i++) {
    		objectCardDrawA[i] = new CardViewer();
    	}
    	
    	objectCardBattleA = new CardViewer[17];
    	for(int i=1; i<17; i++) {
    		objectCardBattleA[i] = new CardViewer();
    	}
    	
    	objectCardDrawB = new CardViewer[8];
    	for(int i=1; i<8; i++) {
    		objectCardDrawB[i] = new CardViewer();
    	}
    	
    	objectCardBattleB = new CardViewer[17];
    	for(int i=1; i<17; i++) {
    		objectCardBattleB[i] = new CardViewer();
    	}

        cardViewImage.setImage(new Image("file:src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png"));

    	
    }

    @FXML
    void drawCard(MouseEvent event) {
    	System.out.println("test"); //debug
    	
    	int turn = state.getTurn();
    	
    	if(turn == 1) {
        	for(int i=1; i<8; i++) {
        		if(objectCardDrawA[i].getAda()) {
        			continue;
        		}
        		Card drawn = state.getPlayer(1).getDecks().drawCard();
        		//TO DO: ISI BERDASARKAN KARTU TOP DARI DECKNYA
        		objectCardDrawA[i] = new CardViewer(true, true, drawn);
        		//TO DO: ISI TEXT BERDASARKAN KARTUNYA
        		String description = objectCardDrawA[i].getCard().getElement().toString(); 
            	cardDrawAText[i].setText(description);
            	break;
            	//TO DO: SET WARNA RECTANGLE BERDASARKAN ELEMENNYA (OPTIONAL)
        	}
    	}
    	
    	else if(turn == 2) {
        	for(int i=1; i<8; i++) {
        		if(objectCardDrawB[i].getAda()) {
        			continue;
        		}
        		Card drawn = state.getPlayer(2).getDecks().drawCard();
        		//TO DO: ISI BERDASARKAN KARTU TOP DARI DECKNYA
        		objectCardDrawB[i] = new CardViewer(true, true, drawn);
        		//TO DO: ISI TEXT BERDASARKAN KARTUNYA
        		String description = objectCardDrawB[i].getCard().getElement().toString(); 
            	cardDrawBText[i].setText(description);
            	break;
            	//TO DO: SET WARNA RECTANGLE BERDASARKAN ELEMENNYA (OPTIONAL)
        	}
    	}
    }

    @FXML
    void viewCard(MouseEvent event) {
    	System.out.println("test"); //debug
    	String id = ((Node) event.getSource()).getId();
        
        char type = id.charAt(4);
        char player = '0';
        int box = 0;
        
        if(type == 'D') {
        	box = Integer.parseInt(id.substring(9,id.length()));
        	player = id.charAt(8);
        }
        else if(type == 'B') {
        	box = Integer.parseInt(id.substring(11,id.length()));
        	player = id.charAt(10);
        }
        
        if(player == 'A') {
        	if(type == 'D') {
            	if(objectCardDrawA[box].getAda() && state.getTurn() == 1) {
                	cardViewImage.setImage(new Image("file:".concat(objectCardDrawA[box].getCard().getPath())));
                	cardViewName.setText(objectCardDrawA[box].getCard().getName());
                	cardViewId.setText(objectCardDrawA[box].getCard().getElement().toString());
                	cardViewDescription.setText(objectCardDrawA[box].getCard().getDesc());
                	System.out.println("file:".concat(objectCardDrawA[box].getCard().getPath())); //debug
            	}
        	} else if(type == 'B') {
            	if(objectCardBattleA[box].getAda() && state.getTurn() == 1) {
                	cardViewImage.setImage(new Image("file:../".concat(objectCardBattleA[box].getCard().getPath())));
                	cardViewName.setText(objectCardBattleA[box].getCard().getName());
                	cardViewId.setText(objectCardBattleA[box].getCard().getElement().toString());
                	cardViewDescription.setText(objectCardBattleA[box].getCard().getDesc());
                	System.out.println(id); //debug
            	}
        	}
        	

        } else if(player == 'B') {
        	if(type == 'D') {
            	if(objectCardDrawB[box].getAda() && state.getTurn() == 2) {
                	cardViewImage.setImage(new Image("file:../".concat(objectCardDrawB[box].getCard().getPath())));
                	cardViewName.setText(objectCardDrawB[box].getCard().getName());
                	cardViewId.setText(objectCardDrawB[box].getCard().getElement().toString());
                	cardViewDescription.setText(objectCardDrawB[box].getCard().getDesc());
                 	System.out.println(id); //debug
            	}
        	} else if(type == 'B') {
            	if(objectCardBattleB[box].getAda() && state.getTurn() == 2) {
                	cardViewImage.setImage(new Image("file:../".concat(objectCardBattleB[box].getCard().getPath())));
                	cardViewName.setText(objectCardBattleB[box].getCard().getName());
                	cardViewId.setText(objectCardBattleB[box].getCard().getElement().toString());
                	cardViewDescription.setText(objectCardBattleB[box].getCard().getDesc());
                	System.out.println(id); //debug
            	}
        	}
        }
    }

}
