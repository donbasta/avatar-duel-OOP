package com.avatarduel.gui;

import com.avatarduel.cards.Card;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller of cardhover.fxml 
 *
 * @author 
 */
public class CardHoverController extends StackPane {
	
	@FXML
    private Text cardViewName;

    @FXML
    private Text cardViewId;

    @FXML
    private ImageView cardViewImage;
    
    @FXML
    private Text cardViewDescription;
    
    @FXML
    void initialize(){
        System.out.println("HOVER");
        this.cardViewName.setText("HEEELLOO");
    }
    
    public void setImage(String url) {
    	cardViewImage.setImage(new Image(url));
    }
    
    public void updateView(Card card){
    	cardViewImage.setImage(new Image("file:".concat(card.getPath())));
    	cardViewName.setText(card.getName());
    	cardViewId.setText(card.getElement().toString());
    	cardViewDescription.setText(card.getDesc());
    	System.out.println("file:".concat(card.getPath())); //debug
    }
    
}
