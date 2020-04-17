package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CardHoverViewer extends StackPane {
	
	@FXML
   private Text cardViewName;

   @FXML
   private Text cardViewId;

   @FXML
   private ImageView cardViewImage;
   
   @FXML
   private Text cardViewDescription;

   private Controller controller;

   @FXML
   void initialize(){
       System.out.println("HOVER");
       this.cardViewName.setText("HEEELLOO");
   }

    public void setController(Controller controller) {
    	this.controller = controller;
    }

    public void updateView(){
        System.out.println("HOVER");
    }
   
/*@FXML
   void viewCard(MouseEvent event) {
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
               	cardViewImage.setImage(new Image("file:".concat(objectCardBattleA[box].getCard().getPath())));
               	cardViewName.setText(objectCardBattleA[box].getCard().getName());
               	cardViewId.setText(objectCardBattleA[box].getCard().getElement().toString());
               	cardViewDescription.setText(objectCardBattleA[box].getCard().getDesc());
               	System.out.println(id); //debug
           	}
       	}
       	
       } else if(player == 'B') {
       	if(type == 'D') {
           	if(objectCardDrawB[box].getAda() && state.getTurn() == 2) {
               	cardViewImage.setImage(new Image("file:".concat(objectCardDrawB[box].getCard().getPath())));
               	cardViewName.setText(objectCardDrawB[box].getCard().getName());
               	cardViewId.setText(objectCardDrawB[box].getCard().getElement().toString());
               	cardViewDescription.setText(objectCardDrawB[box].getCard().getDesc());
                	System.out.println(id); //debug
           	}
       	} else if(type == 'B') {
           	if(objectCardBattleB[box].getAda() && state.getTurn() == 2) {
               	cardViewImage.setImage(new Image("file:".concat(objectCardBattleB[box].getCard().getPath())));
               	cardViewName.setText(objectCardBattleB[box].getCard().getName());
               	cardViewId.setText(objectCardBattleB[box].getCard().getElement().toString());
               	cardViewDescription.setText(objectCardBattleB[box].getCard().getDesc());
               	System.out.println(id); //debug
           	}
       	}
       }
   }
	*/
}
