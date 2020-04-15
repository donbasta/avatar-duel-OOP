package com.avatarduel.gui;

import com.avatarduel.cards.*;
import com.avatarduel.model.Element;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CardViewer extends StackPane {
	
	private boolean isUp;
	private boolean isAda;
	private Card card;
	private int owner;
	private boolean isClick;
	
	public CardViewer() {
		this.isUp = false;
		this.isAda = false;
		this.card = new Card("","",Element.FIRE,"");
		this.isClick = false;
		this.owner = 0;
	}
	
	public CardViewer(Card card, int player) {
		
		Rectangle rect = new Rectangle();
		rect.setHeight(84);
		rect.setWidth(69);
	    rect.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
	        event.consume();
	    });
		
		Text text = new Text(this.getText(card));
		
		this.owner = player;
		this.isUp = false;
		this.card = card;
		this.isClick = false;
		
		this.getChildren().addAll(rect, text);
	
	}
	
    String getText(Card card) {
    	String description = "";
		if(card.getClass().getSimpleName().equals("LandCard")) {
			description = "LAND";
		} else if(card.getClass().getSimpleName().equals("CharacterCard")) {
			CharacterCard chd = (CharacterCard) card;
			description = String.format("PWR %d\nATK %d\nDEF %d", chd.getPower(), chd.getAttack(), chd.getDefense());
		} else if(card.getClass().getSimpleName().equals("SkillCard")) {
			SkillCard scd = (SkillCard) card;
			description = String.format("%s\nPWR %d\n ATK %d\n DEF %d", scd.getType(), scd.getPower(), scd.getAttackIncrease(), scd.getDefenseIncrease());
		}
		return description;
    }
	
	public void setUp(boolean b) {
		this.isUp = b;
	}
	
	public void setAda(boolean b) {
		this.isAda = b;
	}
	
	public void setImagePath(Card card) {
		this.card = card;
	}
	
	public boolean getUp() {
		return this.isUp;
	}
	
	public boolean getAda() {
		return this.isAda;
	}
	
	public Card getCard() {
		return this.card;
	}

}
