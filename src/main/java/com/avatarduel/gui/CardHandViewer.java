package com.avatarduel.gui;

import com.avatarduel.cards.*;
import com.avatarduel.model.Element;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CardHandViewer extends CardViewer{
	
	private boolean isUp;
	
	public CardHandViewer(Card card, Controller controller, int p) {
		
		super(controller, true, card, false, p);
		
		this.isUp = true;
		
		Rectangle rect = (Rectangle) this.getChildren().get(0);
		Text text = (Text) this.getChildren().get(1);
		
		rect.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
			if(!this.isClick) {
				rect.setStyle("-fx-stroke: black; -fx-stroke-width: 5;");
				isClick = true;
				
				try {
					Rectangle previousClickedCard = (Rectangle) CardController.clickedCard.getChildren().get(0);
					previousClickedCard.setStyle(null);
					CardController.clickedCard.setClick(false);
				} catch (Exception e) {
					
				}

				CardController.clickedCard = this;
			} else {
				controller.handleHandCard(this);
			}
		});
		rect.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
	        controller.updateView(this.card);
	    });
		rect.setFill(getColor(card));
		
		text.setText(this.getText(card));
	
	}
	
	public boolean getUp() {
		return this.isUp;
	}
	
	public void setUp(boolean b) {
		this.isUp = b;
	}

}