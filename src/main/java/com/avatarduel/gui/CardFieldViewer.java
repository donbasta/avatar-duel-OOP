package com.avatarduel.gui;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * CardFieldViewer is a card viewer for cards currently
 * in field
 *
 * @author 
 */
public class CardFieldViewer extends CardViewer {
	
	public CardFieldViewer(Controller controller, int p) {
		super(controller, false, null, false, p);
		
		Rectangle rect = (Rectangle) this.getChildren().get(0);
		Text text = (Text) this.getChildren().get(1);
		
		rect.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
			if(!this.isClick) {
				rect.setStyle("-fx-stroke: black; -fx-stroke-width: 5;");
				isClick = true;
				
				try {
					Rectangle previousClickedCard = (Rectangle) CardController.clickedCard.getChildren().get(0);
					if(!(CardController.clickedCard).getOnAttackPosition()) {
						previousClickedCard.setStyle(null);
					} else {
						previousClickedCard.setStyle("-fx-stroke: yellow; -fx-stroke-width: 5;");
					}
					
					CardController.clickedCard.setClick(false);
				} catch (Exception e) {
					
				}

				CardController.clickedCard = this;
			} else {
				controller.handleFieldCard(this);
			}
		});
		
		rect.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
			System.out.print(isAda);
			if(this.isAda) {
				try {
					controller.updateView(this.card);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    });
		
		rect.setFill(Color.TRANSPARENT);
		
		text.setText("???");
		
	}

}