package com.avatarduel.gui;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.SkillCard;
import com.avatarduel.model.Element;
import com.avatarduel.phase.*;
import com.avatarduel.state.Player;
import com.avatarduel.state.State;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class Controller {
	
	@FXML
	private Pane mainPane;

	@FXML
	private CardController cardController;
	
    @FXML
    private DeckController deckController;
    
    @FXML
    private CardHoverController cardHoverController;

	@FXML
	private Button btnDraw;

	@FXML
	private Button btnMain;

	@FXML
	private Button btnBattle;

	@FXML
	private Button btnEnd;
	
	@FXML
	private Button btnRemove;
    
    protected Player[] player;
    protected State state;
    
    @FXML
    public void initialize() {
    	
    	System.out.println("test cuy"); //debug
    	Scene scene = mainPane.getScene();
    	
    	deckController.setController(this);
    	cardController.setController(this);
    	cardHoverController.setController(this);
    	cardHoverController.setImage("file:src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png");
    	
    }
    
    public void setPlay(Player pa, Player pb, State st) {
    	
    	player = new Player[3];
    	player[1] = pa;
    	player[2] = pb;
    	state = st;
    	
    	Card cd;
    	
    	for(int i=1; i<=2; i++) {
    		for(int j=1; j<=7; j++) {
        		try {
					Card card = player[i].getDecks().drawCard();
					cardController.addCardToHand(i, card);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
        	}
    	}
    	
		for(int i=1; i<=6; i++) {
			cardController.fieldChar[1].addCardToField(this, 1);
			cardController.fieldChar[2].addCardToField(this, 2);
			cardController.fieldSkill[1].addCardToField(this, 1);
			cardController.fieldSkill[2].addCardToField(this, 2);
		}
    	
		this.update();
    }
    
    public void handleFieldCard(CardViewer c) {
    	
    	System.out.println("why??");
    	
    	Phase ph = this.state.getPhase();
    	
    	// kalau masih battle phase, ada dua kemungkinan, ngeremove card sama ngemutar (change position) card
    	Card card = c.getCard();
    	String type = card.getClass().getSimpleName();
    	
    	if(c.getOwner() == this.state.getTurn()) {
    		
    		System.out.println("LOL");
    		
    		if(type.equals("CharacterCard")) { 
    			Rectangle rect = (Rectangle) c.getChildren().get(0);
    			CharacterCard chcard = (CharacterCard) card;
    			System.out.println("lol");
    			if(chcard.getPosition().equals("ATTACK")) {
    				System.out.println("lol1");
        			rect.setHeight(69);
        			rect.setWidth(84);
        			chcard.setPosition("DEFENCE");
    			} else if(chcard.getPosition().equals("DEFENCE")) {
    				System.out.println("lol2");
        			rect.setHeight(84);
        			rect.setWidth(69);
        			chcard.setPosition("ATTACK");
    			}
			}
    		
    	}
    	
    }

	public void handleHandCard(CardViewer c){
		
		System.out.println("DIKLIK");
		Phase ph = this.state.getPhase();

		if(c.getOwner() == this.state.getTurn() && ph.canUseCard){
			
			System.out.println("HEHE\n");
			int currentTurn = this.state.getTurn();
			
			//TO DO: ngecek apakah dia land atau skill atau character, terus tambahin ke yg bersesuaian
			
			Card card = c.getCard();
			String type = card.getClass().getSimpleName();
	//				System.out.println(type);
			if(type.equals("CharacterCard")) { //if dia character, lgsg taro aja di, klik di tempat yg kosong di kotak character
				
				try {
					player[currentTurn].getDecks().addToFieldCharacter(card, player[currentTurn].getPower());
					cardController.addCardToField(c.getOwner(), card);
					cardController.removeCard(c, this.state.getTurn());
					deckController.setPower(currentTurn, player[currentTurn].getPower());
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				
			} else if(type.equals("LandCard")) { //if dia land, lgsg ubah powernya
				System.out.println("DEBUG");
				if(ph.getClass().getSimpleName().equals("MainPhase")){
					MainPhase mph = (MainPhase) this.state.getPhase();
					if(mph.getCanUseLandCard()) {
						player[currentTurn].incrementPower(card.getElement());
						deckController.setPower(currentTurn, player[currentTurn].getPower());
						mph.setLandCardUsed();
						cardController.removeCard(c, this.state.getTurn());
					}
				}
				
			//if dia skill, cek dia aura, skill, atau powerup, terus pilih kartu target, terus 'ngebind' jadi kalo targetnya mati
			// dia juga bakal mati	
				
			} else if(type.equals("SkillCard")) {
				System.out.println("DEBUG");
				cardController.removeCard(c, this.state.getTurn());
			}
			
		}
	}

	private void update(){
		int turn = this.state.getTurn();
		Phase ph = this.state.getPhase();
		/* enable / disable phase button */
		btnDraw.setDisable(!ph.drawBtn);
		btnMain.setDisable(!ph.mainBtn);
		btnBattle.setDisable(!ph.battleBtn);
		btnEnd.setDisable(!ph.endturnBtn);
	}

	private void resetPower(){
		int turn = this.state.getTurn();
	}
    
    public void handleDrawCard(int p) {
		if(this.state.getTurn() == p && this.state.getPhase().canDraw){
			try {
				Card card = player[p].getDecks().drawCard();
				cardController.addCardToHand(p, card);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			Phase ne = new MainPhase();
			this.state.setPhase(ne);
			this.update();
		}
    }

	public void updateView(Card card){
//		System.out.println("KESINI");
		cardHoverController.updateView(card);
	}
   
}
