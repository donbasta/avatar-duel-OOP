package com.avatarduel.gui;

import javafx.scene.paint.Color;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controller {

	@FXML
    private Text cardViewName;

    @FXML
    private Text cardViewId;

    @FXML
    private ImageView cardViewImage;

    @FXML
    private Rectangle cardBattleA9;

    @FXML
    private Rectangle cardBattleA10;

    @FXML
    private Rectangle cardBattleA11;

    @FXML
    private Rectangle cardBattleA12;

    @FXML
    private Rectangle cardBattleA13;

    @FXML
    private Rectangle cardBattleA14;

    @FXML
    private Rectangle cardBattleA15;

    @FXML
    private Rectangle cardBattleA16;

    @FXML
    private Rectangle cardBattleB9;

    @FXML
    private Rectangle cardBattleB10;

    @FXML
    private Rectangle cardBattleB11;

    @FXML
    private Rectangle cardBattleB12;

    @FXML
    private Rectangle cardBattleB13;

    @FXML
    private Rectangle cardBattleB14;

    @FXML
    private Rectangle cardBattleB15;

    @FXML
    private Rectangle cardBattleB16;

    @FXML
    private Rectangle cardBattleB1;

    @FXML
    private Rectangle cardBattleB2;

    @FXML
    private Rectangle cardBattleB3;

    @FXML
    private Rectangle cardBattleB4;

    @FXML
    private Rectangle cardBattleB5;

    @FXML
    private Rectangle cardBattleB6;

    @FXML
    private Rectangle cardBattleB7;

    @FXML
    private Rectangle cardBattleB8;

    @FXML
    private Rectangle cardDrawB1;

    @FXML
    private Rectangle cardDrawB2;

    @FXML
    private Rectangle cardDrawB3;

    @FXML
    private Rectangle cardDrawB4;

    @FXML
    private Rectangle cardDrawB5;

    @FXML
    private Rectangle cardDrawB6;

    @FXML
    private Rectangle cardDrawB7;

    @FXML
    private Rectangle cardBattleA1;

    @FXML
    private Rectangle cardBattleA2;

    @FXML
    private Rectangle cardBattleA3;

    @FXML
    private Rectangle cardBattleA4;

    @FXML
    private Rectangle cardBattleA5;

    @FXML
    private Rectangle cardBattleA6;

    @FXML
    private Rectangle cardBattleA7;

    @FXML
    private Rectangle cardBattleA8;

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
    private Text[] cardDrawAText;
    
    @FXML
    public void initialize() {
    	
    	System.out.println("test cuy"); //debug
    	
    	cardDrawA = new Rectangle[8];
    	cardDrawA[1] = cardDrawA1;
    	cardDrawA[2] = cardDrawA2;
    	cardDrawA[3] = cardDrawA3;
    	cardDrawA[4] = cardDrawA4;
    	cardDrawA[5] = cardDrawA5;
    	cardDrawA[6] = cardDrawA6;
    	cardDrawA[7] = cardDrawA7;
    	
    	cardDrawAText = new Text[8];
    	cardDrawAText[1] = cardDrawA1Text;
    	cardDrawAText[2] = cardDrawA2Text;
    	cardDrawAText[3] = cardDrawA3Text;
    	cardDrawAText[4] = cardDrawA4Text;
    	cardDrawAText[5] = cardDrawA5Text;
    	cardDrawAText[6] = cardDrawA6Text;
    	cardDrawAText[7] = cardDrawA7Text;
    	
    }

    @FXML
    void drawCard(MouseEvent event) {
    	System.out.println("test"); //debug
    	cardDrawA[1].setFill(Color.ANTIQUEWHITE);
//    	cardDrawAText[1].setText("dd"); //ini somehow null pointer exception
//    	deck1.setFill(Color.GREEN);
    }

    @FXML
    void viewCard(MouseEvent event) {
    	System.out.println("test"); //debug
    	String id = ((Node) event.getSource()).getId();
        System.out.println(id); //debug
        
        switch (id) {
        case "cardDrawA1" :
//        	cardViewImage.setImage(new Image(getClass().getResource("card/image/land/Omashu.png").toString(), true));
        	cardViewName.setText("Omashu");
        	cardViewId.setText("Land");
        //TO DO
        case "cardDrawA2" :
        case "cardDrawA3" :
        case "cardDrawA4" :
        case "cardDrawA5" :
        case "cardDrawA6" :
        case "cardDrawA7" :
        case "cardDrawB1" :
        case "cardDrawB2" :
        case "cardDrawB3" :
        case "cardDrawB4" :
        case "cardDrawB5" :
        case "cardDrawB6" :
        case "cardDrawB7" :
        case "cardBattleA1" :
        case "cardBattleA2" :
        case "cardBattleA3" :
        case "cardBattleA4" :
        case "cardBattleA5" :
        case "cardBattleA6" :
        case "cardBattleA7" :
        case "cardBattleA8" :
        case "cardBattleA9" :
        case "cardBattleA10" :
        case "cardBattleA11" :
        case "cardBattleA12" :
        case "cardBattleA13" :
        case "cardBattleA14" :
        case "cardBattleA15" :
        case "cardBattleA16" :
        case "cardBattleB1" :
        case "cardBattleB2" :
        case "cardBattleB3" :
        case "cardBattleB4" :
        case "cardBattleB5" :
        case "cardBattleB6" :
        case "cardBattleB7" :
        case "cardBattleB8" :
        case "cardBattleB9" :
        case "cardBattleB10" :
        case "cardBattleB11" :
        case "cardBattleB12" :
        case "cardBattleB13" :
        case "cardBattleB14" :
        case "cardBattleB15" :
        case "cardBattleB16" :

        }
    }

}
