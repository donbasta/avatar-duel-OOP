package com.avatarduel.gui;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.SkillCard;
import com.avatarduel.model.Element;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * CardViewer is FXML custom component
 * which inherits StackPane, functions
 * as the container of the card
 *
 * @author 
 */
public class CardViewer extends StackPane {

	protected boolean isAda;
	protected Card card;
	protected boolean isClick;
	protected Controller controller;
	protected int owner;
	boolean onAttackPosition;
	
	public CardViewer(Controller controller, boolean ada, Card cd, boolean click, int p) {
		this.controller = controller;
		this.isAda = ada;
		this.card = cd;
		this.isClick = click;
		this.owner = p;
		this.onAttackPosition = false;
		
		Rectangle rect = new Rectangle();

		rect.setHeight(84);
		rect.setWidth(69);
	    rect.setFill(Color.TRANSPARENT);
	    Text text = new Text("");
		
		this.getChildren().addAll(rect, text);
	}
	
	public void setAda(boolean b) {
		this.isAda = b;
	}
	
	public void setCard(Card card) {
		this.isAda = true;
		this.card = card;
		((Rectangle) this.getChildren().get(0)).setFill(getColor(card));
		((Text) this.getChildren().get(1)).setText(this.getText(card));
	}
	
	public void setClick(boolean click) {
		this.isClick = click;
	}
	
	public boolean getAda() {
		return this.isAda;
	}
	
	public Card getCard() {
		return this.card;
	}

	public int getOwner(){
		return this.owner;
	}
	
	public void setOnAttackPosition(boolean onAttack) {
		this.onAttackPosition = onAttack;
	}
	
	public boolean getOnAttackPosition() {
		return this.onAttackPosition;
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
			if(scd.getType().equals("aura")){
				String incatk, incdef;
				if(scd.getAttackIncrease() >= 0){
					incatk = "+" + Integer.toString(scd.getAttackIncrease());
				} else {
					incatk = "-" + Integer.toString(-1 * scd.getAttackIncrease());
				}
				if(scd.getDefenseIncrease() >= 0){
					incdef = "+" + Integer.toString(scd.getDefenseIncrease());
				} else {
					incdef = "-" + Integer.toString(-1 * scd.getDefenseIncrease());
				}
				description = String.format("%s\nPWR %d\n ATK %s\n DEF %s", scd.getType(), scd.getPower(), incatk, incdef);
			} else {
				description = String.format("%s\nPWR %d", scd.getType(), scd.getPower());
			}
		}
		return description;
		
    }
    
	Color getColor(Card cd) {
		
		Color warna = Color.TRANSPARENT;
		if(cd.getElement() == Element.WATER) {
			warna = Color.LIGHTBLUE;
		} else if(cd.getElement() == Element.FIRE) {
			warna = Color.CRIMSON;
		} else if(cd.getElement() == Element.EARTH) {
			warna = Color.LIGHTGREEN;
		} else if(cd.getElement() == Element.AIR) {
			warna = Color.LIGHTYELLOW;
		}
		return warna;
		
	}
	
}
