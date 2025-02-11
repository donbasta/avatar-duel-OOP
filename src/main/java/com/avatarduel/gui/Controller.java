package com.avatarduel.gui;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.SkillCard;
import com.avatarduel.phase.*;
import com.avatarduel.state.Player;
import com.avatarduel.state.State;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML main controller
 *
 * @author 
 */
public class Controller {
	
	@FXML private Pane mainPane;

	@FXML private CardController cardController;
	
    @FXML private DeckController deckController;
    
    @FXML private CardHoverController cardHoverController;

	@FXML private Button btnDraw;

	@FXML private Button btnMain;

	@FXML private Button btnBattle;

	@FXML private Button btnEnd;
	
	@FXML private Button btnRemove;
	
	@FXML private Button btnDirectAttack;
    
    protected Player[] player;
    public State state;
    public boolean gameOver;
    
    @FXML
    public void initialize() {
    	deckController.setController(this);
    	cardController.setController(this);
    	cardHoverController.setImage("file:src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png");
    }
    
    @FXML
	public void goBattle(MouseEvent event){
		BattlePhase a = new BattlePhase();
		this.state.setPhase(a);
		this.update();
	}

	@FXML
	public void endTurn(MouseEvent event){
		
		Phase ph = this.state.getPhase();
		
		if(ph.activeAttackingCardViewer != null) {
			((Rectangle) ph.activeAttackingCardViewer.getChildren().get(0)).setStyle(null);
			((CardFieldViewer) ph.activeAttackingCardViewer).setOnAttackPosition(false);
			ph.activeAttackingCardViewer = null;
			ph.activeAttackingCard = null;
		}

		cardController.resetAttacked(this.state.getTurn());
		
		this.state.changeTurn();
		DrawPhase a = new DrawPhase();
		this.state.setPhase(a);
		this.update();
		deckController.setCurrentTurn(this.state.getTurn());
		
		if(this.player[this.state.getTurn()].getDecks().getDeck().isEmpty()) {
			// KALAH
			this.endGame(this.state.getTurn());
		}
		
		this.switchHide();
		
	}
	
	@FXML
	public void removeCard(MouseEvent event) {
		
		Phase ph = this.state.getPhase();
		int currentTurn = this.state.getTurn();
		CardViewer currentClicked = CardController.clickedCard;
		if(ph.canRemove && currentClicked.getOwner() == currentTurn) {
			
			if(currentClicked.getClass().getSimpleName().equals("CardHandViewer")) {
				//buang kartu pada tempat tersebut, kurangin yg ada di deck jangan lupa
				cardController.removeCard(currentClicked, currentTurn);
				player[currentTurn].getDecks().removeCardFromHand(currentClicked.card);
			} else if(currentClicked.getClass().getSimpleName().equals("CardFieldViewer")) {
				//buang kartunya, kurangin yg ada di deck jangan lupa
				Card card = currentClicked.card;
				if(card.getClass().getSimpleName().equals("SkillCard")) {
					SkillCard scd = (SkillCard) card;
					
					if(scd.getType().contentEquals("aura")) {	
						
						CardFieldViewer cfviewer = null;
						
						for(int i=1; i<=2; i++) {
							CardTable findCard = cardController.getField(i).getCharacter();
							for(Node child : findCard.getChildren()){
								CardFieldViewer cv = (CardFieldViewer) child;
								CharacterCard chcard = (CharacterCard) cv.getCard();
								if(chcard != null && chcard.getEquippedSkill().contains(currentClicked)) {
									//ubah textnya
									cfviewer = cv;
								}
							}
						}
						
						if(cfviewer != null) {
							cardController.removeCharacter(cfviewer);
							((CharacterCard) cfviewer.getCard()).dropSkill(currentClicked);
							cardController.addCardToField(cfviewer.getOwner(), ((CharacterCard) cfviewer.getCard()));	
							cardController.removeSkill(currentClicked);
							player[currentTurn].getDecks().removeCardFromField(card);
						}

						
					} else if(scd.getType().contentEquals("powerup")) {
						
						for(int i=1; i<=2; i++) {
							for(Card chcard : player[i].getDecks().getCharacterCard()) {
								CharacterCard charcard = (CharacterCard) chcard;
								if(charcard.getEquippedSkill().contains(currentClicked)) {
									charcard.getEquippedSkill().remove(currentClicked);
									charcard.setPowerUp(false);
									for(CardViewer equipcard : charcard.getEquippedSkill()) {
										if(((SkillCard) equipcard.getCard()).getType().equals("powerup")) {
											charcard.setPowerUp(true);
										}
									}
								}
							}
						}
						
						cardController.removeSkill(currentClicked);
						player[currentTurn].getDecks().removeCardFromField(card);
					}
					
				}
				
			}
			
		}
		
	}
	
	@FXML
	public void attackDirectly(MouseEvent event) {
		
		Phase ph = this.state.getPhase();
		int opponent = 3-this.state.getTurn();
		if(ph.attackActive) {
			if(player[opponent].getDecks().getCharacterCard().isEmpty()) {
				try {
					((BattlePhase) ph).attackDirectly(player[opponent]);
					deckController.setHpText(opponent, player[opponent].getHealth());
					deckController.setProgressBarHp(opponent, player[opponent].getHealth());
					if(player[opponent].getHealth() <= 0) {
    					// KALAH
						this.endGame(opponent);
    				}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			((Rectangle) ph.activeAttackingCardViewer.getChildren().get(0)).setStyle(null);
			((CardFieldViewer) ph.activeAttackingCardViewer).setOnAttackPosition(false);
			ph.activeAttackingCardViewer = null;
			ph.activeAttackingCard = null;
			ph.canAttack = true;
			ph.attackActive = false;
		}
		
	}
    
    public void setPlay(Player pa, Player pb, State st) {
    	
    	player = new Player[3];
    	player[1] = pa;
    	player[2] = pb;
    	state = st;
    	
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
			for(int j=1; j<=2; j++) {
				cardController.fieldChar[j].addCardToField(this, j);
				cardController.fieldSkill[j].addCardToField(this, j);
			}
		}

		this.hideOpponentCard();
		
		for(int i=1; i<=2; i++) {
			deckController.setNumCardDeck(i, player[i].getDecks().getDeck().size());
		}
    	
		this.update();
    }

	public void hideOpponentCard(){
		cardController.hide(this.state.getTurn());
	}

	public void switchHide(){
		cardController.switchHide();
	}
    
    public void handleDrawCard(int p) {
		if(this.state.getTurn() == p && this.state.getPhase().canDraw){
			try {
				Card card = player[p].getDecks().drawCard();
				cardController.addCardToHand(p, card);
				deckController.setNumCardDeck(p, player[p].getDecks().getDeck().size());
				Phase ne = new MainPhase();
				this.state.setPhase(ne);
				this.update();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
    }
    
    public void handleHandCard(CardViewer c){

		Phase ph = this.state.getPhase();

		if(c.getOwner() == this.state.getTurn() && ph.canUseCard && !ph.destroyActive && !ph.skillActive){

			int currentTurn = this.state.getTurn();
			Card card = c.getCard();
			String type = card.getClass().getSimpleName();
			if(type.equals("CharacterCard")) {
				
				try {
					player[currentTurn].getDecks().addToFieldCharacter((CharacterCard) card, player[currentTurn].getPower());
					cardController.addCardToField(c.getOwner(), card);
					cardController.removeCard(c, this.state.getTurn());
					deckController.setPower(currentTurn, player[currentTurn].getPower());
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				
			} else if(type.equals("LandCard")) {
				
				if(ph.getClass().getSimpleName().equals("MainPhase")){
					MainPhase mph = (MainPhase) this.state.getPhase();
					if(mph.getCanUseLandCard()) {
						player[currentTurn].incrementPower(card.getElement());
						player[currentTurn].getDecks().useLand(card);
						deckController.setPower(currentTurn, player[currentTurn].getPower());
						mph.setLandCardUsed();
						cardController.removeCard(c, this.state.getTurn());
					}
				}
				
			} else if(type.equals("SkillCard")) {
				
				SkillCard scd = (SkillCard) card;
				if(scd.getType().equals("destroy")){
					if(player[currentTurn].getPower().getPower(scd.getElement()) >= scd.getPower()){
						player[currentTurn].getDecks().removeCardFromHand(scd);
						player[currentTurn].usePower(scd.getElement(), scd.getPower());
						deckController.setPower(currentTurn, player[currentTurn].getPower());
						this.state.getPhase().destroyActive = true;
						cardController.removeCard(c, this.state.getTurn());
					}
				} else if(scd.getType().equals("aura")){
					if(player[currentTurn].getPower().getPower(scd.getElement()) >= scd.getPower() && cardController.characterNotEmpty()){
						player[currentTurn].getDecks().removeCardFromHand(scd);
						player[currentTurn].usePower(scd.getElement(), scd.getPower());
						deckController.setPower(currentTurn, player[currentTurn].getPower());
						this.state.getPhase().skillActive = true;
						this.state.getPhase().activeSkill = (SkillCard) card;
						cardController.removeCard(c, this.state.getTurn());
					}
				} else if(scd.getType().equals("powerup")){
					if(player[currentTurn].getPower().getPower(scd.getElement()) >= scd.getPower()){
						player[currentTurn].getDecks().removeCardFromHand(scd);
						player[currentTurn].usePower(scd.getElement(), scd.getPower());
						deckController.setPower(currentTurn, player[currentTurn].getPower());
						this.state.getPhase().powerupActive = true;
						this.state.getPhase().activeSkill = (SkillCard) card;
						cardController.removeCard(c, this.state.getTurn());
					}
				}
			}
		}
	}
    
    public void handleFieldCard(CardViewer c) {
    	
    	Phase ph = this.state.getPhase();
    	Card card = c.getCard();
    	System.out.println(card==null);
    	System.out.println("lolz");
    	String type = card.getClass().getSimpleName();
    	
    	if(this.state.getPhase().canAttack) {
    		
    		if(type.equals("CharacterCard")) {
    			CharacterCard chcard = (CharacterCard) card;
        		if(c.getOwner() == this.state.getTurn()) {
        			((Rectangle) c.getChildren().get(0)).setStyle("-fx-stroke: yellow; -fx-stroke-width: 5;");
        			((CardFieldViewer) c).setOnAttackPosition(true);
        			ph.activeAttackingCardViewer = c;
        			ph.activeAttackingCard = chcard;
        			ph.canAttack = false;
        			ph.attackActive = true;
        		}
    		}
    		
    	} else if(this.state.getPhase().attackActive) {
    		
    		if(c.getOwner() != this.state.getTurn()) {
    			try {
    				if(type.equals("CharacterCard")) {
    					int opponent = 3-this.state.getTurn();
        				BattlePhase bph = (BattlePhase) ph;
        				boolean removed = bph.attack((CharacterCard) c.getCard(), player[opponent]);
        				if(removed) {
							for(CardViewer skill : ((CharacterCard) card).getEquippedSkill()){
								cardController.removeSkill(skill);
								player[skill.getOwner()].getDecks().removeCardFromField(skill.getCard());
							}
        					cardController.removeCharacter(c);
							player[opponent].getDecks().removeCardFromField(c.getCard());
        				}
        				deckController.setHpText(opponent, player[opponent].getHealth());
        				deckController.setProgressBarHp(opponent, player[opponent].getHealth());
        				if(player[opponent].getHealth() <= 0) {
        					// KALAH
        					this.endGame(opponent);
        				}
    				}
    			} catch (Exception e) {
    				System.out.println(e.getMessage());
    			}

    			((Rectangle) ph.activeAttackingCardViewer.getChildren().get(0)).setStyle(null);
    			((CardFieldViewer) ph.activeAttackingCardViewer).setOnAttackPosition(false);
    			ph.activeAttackingCardViewer = null;
    			ph.activeAttackingCard = null;
    			ph.canAttack = true;
    			ph.attackActive = false;
    			
    		} else if(c.getOwner() == this.state.getTurn()) {
    			
    			((Rectangle) ph.activeAttackingCardViewer.getChildren().get(0)).setStyle(null);
    			((CardFieldViewer) ph.activeAttackingCardViewer).setOnAttackPosition(false);
    			
    			((Rectangle) c.getChildren().get(0)).setStyle("-fx-stroke: yellow; -fx-stroke-width: 5;");
    			((CardFieldViewer) c).setOnAttackPosition(true);
    			ph.activeAttackingCardViewer = c;
    			ph.activeAttackingCard = (CharacterCard) c.getCard();
    			
    		}
   
    	} else if(this.state.getPhase().destroyActive){
    		
			if(type.equals("CharacterCard")){
				//ancurin semua equip
				for(CardViewer skill : ((CharacterCard) card).getEquippedSkill()){
					cardController.removeSkill(skill);
					player[skill.getOwner()].getDecks().removeCardFromField(skill.getCard());
				}
				//ancurin kartu di field
				cardController.removeCharacter(c);
				player[c.getOwner()].getDecks().removeCardFromField(c.getCard());
				player[this.state.getTurn()].getDecks().removeCardFromField(c.getCard());
				this.state.getPhase().destroyActive = false;
			}
			
		} else {
			
			if(this.state.getPhase().skillActive){
				if(type.equals("CharacterCard")){
					CharacterCard cha = (CharacterCard) card;
					cardController.removeCharacter(c);
					CardFieldViewer a = cardController.addSkillToField(this.state.getTurn(), this.state.getPhase().activeSkill);
					cha.useSkill(a);
					cardController.addCardToField(c.getOwner(), cha);
					this.state.getPhase().activeSkill = null;
					this.state.getPhase().skillActive = false;
				}
			} else {
				if(this.state.getPhase().powerupActive){
					if(type.equals("CharacterCard")){
						CharacterCard cha = (CharacterCard) card;
						CardFieldViewer a = cardController.addSkillToField(this.state.getTurn(), this.state.getPhase().activeSkill);
						cha.powerUp(a);
						this.state.getPhase().activeSkill = null;
						this.state.getPhase().powerupActive = false;
					}
				} else {
					// change position of card
					if(c.getOwner() == this.state.getTurn() && !this.state.getPhase().canAttack) {
						if(type.equals("CharacterCard")) { 
							Rectangle rect = (Rectangle) c.getChildren().get(0);
							CharacterCard chcard = (CharacterCard) card;
							if(chcard.getPosition().equals("ATTACK")) {
								rect.setHeight(69);
								rect.setWidth(84);
								chcard.setPosition("DEFENCE");
							} else if(chcard.getPosition().equals("DEFENCE")) {
								rect.setHeight(84);
								rect.setWidth(69);
								chcard.setPosition("ATTACK");
							}
						}
					}
				}
			}
		}
    }

	private void update(){
		Phase ph = this.state.getPhase();
		/* enable / disable phase button */
		btnDraw.setDisable(!ph.drawBtn);
		btnMain.setDisable(!ph.mainBtn);
		btnBattle.setDisable(!ph.battleBtn);
		btnEnd.setDisable(!ph.endturnBtn);

		if(ph.resetPower){
			this.resetPower();
		}
	}

	private void resetPower(){
		int turn = this.state.getTurn();

		player[turn].setPowerToDefault();
		deckController.setPower(turn, player[turn].getPower());
	}

	public void updateView(Card card){
		cardHoverController.updateView(card);
	}
	
	public void endGame(int player) {
		Stage gameOverPopup=new Stage();
		gameOverPopup.initModality(Modality.APPLICATION_MODAL);
		gameOverPopup.setTitle("Game Over");
		Label label1= new Label("Player "+Integer.toString(3-player)+" win!");
		Button button1= new Button("Close to Exit the Game");
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Window stage = mainPane.getScene().getWindow();
			this.gameOver = true;
			gameOverPopup.close();
			((Stage) stage).close();
		});
		VBox layout= new VBox(10);
		layout.getChildren().addAll(label1, button1);
		layout.setAlignment(Pos.CENTER);
		Scene scene1= new Scene(layout, 300, 250);
		gameOverPopup.setScene(scene1);
		gameOverPopup.showAndWait();
	}

}
