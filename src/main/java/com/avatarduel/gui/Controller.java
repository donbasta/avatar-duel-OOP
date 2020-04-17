package com.avatarduel.gui;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.SkillCard;
import com.avatarduel.model.Element;
import com.avatarduel.phase.MainPhase1;
import com.avatarduel.phase.Phase;
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

public class Controller {
	
	@FXML
	private Pane mainPane;

	@FXML
	private CardController cardController;
	
    @FXML
    private DeckController deckController;

	@FXML 
	private CardHoverViewer cardviewerController;
    
    protected Player[] player;
    protected State state;
    protected MainPhase1 mainphase;
    
    public void setPlay(Player pa, Player pb, State st) {
    	
    	player = new Player[2];
    	player[0] = pa;
    	player[1] = pb;
    	state = st;
    	
    	Card cd;
    	
    	for(int i=0; i<2; i++) {
    		for(int j=1; j<=7; j++) {
        		try {
    				cd = player[i].getDecks().drawCard();
//    				addCard(1,cd);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}
    	}
    	
    	
//    	hideCard(2);
//    	numCardDeck1.setText(String.format("%d / %d", state.getPlayer(1).getDecks().getDeck().size(), maksKartu));
//    	numCardDeck2.setText(String.format("%d / %d", state.getPlayer(2).getDecks().getDeck().size(), maksKartu));
    	
    }

    @FXML
    public void initialize() {
    	
    	System.out.println("test cuy"); //debug
    	Scene scene = mainPane.getScene();
    	
    	deckController.setController(this);
    	cardController.setController(this);
		cardviewerController.setController(this);
    	
//    	numCardDeck = new Text[3];
//    	numCardDeck[1] = numCardDeck1;
//    	numCardDeck[2] = numCardDeck2;

//        cardViewImage.setImage(new Image("file:src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png"));
    	
    }
    
    public void handleDrawCard() {
    	cardController.drawCard();
    }

	public void updateView(){
		System.out.println("KESINI");
		cardviewerController.updateView();
	}

//    @FXML
//    void drawCard(MouseEvent event) {
//    	int turn = state.getTurn();
//    	Card drawn;
//		try {
//			drawn = state.getPlayer(turn).getDecks().drawCard();
////	    	numCardDeck[turn].setText(String.format("%d / %d", state.getPlayer(turn).getDecks().getDeck().size(), maksKartu));
//	    	addCard(turn, drawn);
//		} catch (Exception e) {
//			String t = e.toString();
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
//    void hideCard(int numPlayer) {
//    	if(numPlayer == 1) {
//        	for(int i=1; i<=8; i++) {
//        		if(objectCardDrawA[i].getAda()) {
//        			objectCardDrawA[i].setUp(false);
//        			cardDrawA[i].setFill(Color.TRANSPARENT);
//        		}
//        		cardDrawAText[i].setText("???");
//        	}
//    	} else if(numPlayer == 2) {
//    		for(int i=1; i<=8; i++) {
//    			if(objectCardDrawB[i].getAda()) {
//        			objectCardDrawB[i].setUp(false);
//        			cardDrawB[i].setFill(Color.TRANSPARENT);
//        		}
//    			cardDrawBText[i].setText("???");
//    		}
//    	}
//    }
//    
//    void showCard(int numPlayer) {
//    	if(numPlayer == 1) {
//        	for(int i=1; i<=8; i++) {
//        		if(objectCardDrawA[i].getAda()) {
//        			objectCardDrawA[i].setUp(true);
//        			cardDrawAText[i].setText(getDescription(objectCardDrawA[i].getCard()));
//        			cardDrawA[i].setFill(getColor(objectCardDrawA[i].getCard()));
//        		}
//        	}
//    	} else if(numPlayer == 2) {
//    		for(int i=1; i<=8; i++) {
//    			if(objectCardDrawB[i].getAda()) {
//        			objectCardDrawB[i].setUp(true);
//        			cardDrawBText[i].setText(getDescription(objectCardDrawB[i].getCard()));
//        			cardDrawB[i].setFill(getColor(objectCardDrawB[i].getCard()));
//        		}
//    		}
//    	}
//    }
//    
//    String getDescription(Card cd) {
//    	String description = "";
//		if(cd.getClass().getSimpleName().equals("LandCard")) {
//			description = "LAND";
//		} else if(cd.getClass().getSimpleName().equals("CharacterCard")) {
//			CharacterCard chd = (CharacterCard) cd;
//			description = String.format("PWR %d\nATK %d\nDEF %d", chd.getPower(), chd.getAttack(), chd.getDefense());
//		} else if(cd.getClass().getSimpleName().equals("SkillCard")) {
//			SkillCard scd = (SkillCard) cd;
//			description = String.format("%s\nPWR %d\n ATK %d\n DEF %d", scd.getType(), scd.getPower(), scd.getAttackIncrease(), scd.getDefenseIncrease());
//		}
//		return description;
//    }
//    
//    Color getColor(Card cd) {
//    	Color warna = Color.TRANSPARENT;
//    	if(cd.getElement() == Element.WATER) {
//			warna = Color.LIGHTBLUE;
//		} else if(cd.getElement() == Element.FIRE) {
//			warna = Color.CRIMSON;
//		} else if(cd.getElement() == Element.EARTH) {
//			warna = Color.LIGHTGREEN;
//		} else if(cd.getElement() == Element.AIR) {
//			warna = Color.LIGHTYELLOW;
//		}
//    	return warna;
//    }
//    
//    void addCard(int numPlayer, Card cd) {
//    	
//    	if(numPlayer == 1) {
//    		for(int i=1; i<=8; i++) {
//        		if(objectCardDrawA[i].getAda()) {
//        			continue;
//        		}
//        		objectCardDrawA[i] = new CardViewer(cd,1);
//        		String description = getDescription(cd);
//        		cardDrawA[i].setFill(getColor(cd));
//            	cardDrawAText[i].setText(description);
//            	break;
//        	}
//    	} else if(numPlayer == 2) {
//    		for(int i=1; i<=8; i++) {
//        		if(objectCardDrawB[i].getAda()) {
//        			continue;
//        		}
//        		objectCardDrawB[i] = new CardViewer(cd,1);
//        		String description = getDescription(cd);
//        		cardDrawB[i].setFill(getColor(cd));
//            	cardDrawBText[i].setText(description);
//            	break;
//        	}
//    	}
//    	
//    }
    
//    @FXML
//    void mainPhaseCard(MouseEvent event) {
//    	int turn = state.getTurn();
//    	String id = ((Node) event.getSource()).getId();
//    	int box = Integer.parseInt(id.substring(9,id.length()));
//    	char player = id.charAt(8);
//    	
//    	System.out.println(player);
//    	
//    	if(player == 'A' && turn == 1) {
//    		Card main = objectCardDrawA[box].getCard();
//    		mainphase = new MainPhase1(1,state.getPlayer(1).getDecks(), state.getPlayer(1).getPower());
//    		try {
//				mainphase.putCardToField(main);
//				putCardToBattle(main,turn);
//				emptyCell("draw", turn, box);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	} else if(player == 'B' && turn == 2) {
//    		Card main = objectCardDrawB[box].getCard();
//    		mainphase = new MainPhase1(2,state.getPlayer(2).getDecks(), state.getPlayer(2).getPower());
//    		try {
//				mainphase.putCardToField(main);
//				putCardToBattle(main,turn);
//				emptyCell("draw", turn, box);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}	
//    }
    
//    void putCardToBattle(Card c, int player) {
//    	if(player == 1) {
//        	for(int i = 1; i<=16; i++) {
//        		if(objectCardBattleA[i].getAda()) {
//        			continue;
//        		}
//        		objectCardBattleA[i] = new CardViewerBattle(true, true, c, 1);
//        		String description = getDescription(c);
//        		cardBattleA[i].setFill(getColor(c));
//            	cardBattleAText[i].setText(description);
//            	break;
//        	}
//    	}
//    	if(player == 2) {
//        	for(int i = 1; i<=16; i++) {
//        		if(objectCardBattleB[i].getAda()) {
//        			continue;
//        		}
//        		objectCardBattleB[i] = new CardViewerBattle(true, true, c, 1);
//        		String description = getDescription(c);
//        		cardBattleB[i].setFill(getColor(c));
//            	cardBattleBText[i].setText(description);
//            	break;
//        	}
//    	}
//
//    }
    
//    void emptyCell(String location, int player, int position) {
//    	if(player == 1) {
//        	if(location.equals("battle")) {
//        		cardBattleAText[position].setText("???");
//        		cardBattleA[position].setFill(Color.TRANSPARENT);
//        		objectCardBattleA[position] = new CardViewerBattle();
//        	} else if(location.equals("draw")) {
//        		cardDrawAText[position].setText("???");
//        		cardDrawA[position].setFill(Color.TRANSPARENT);
//        		objectCardDrawA[position] = new CardViewer();
//        	}
//    	} else if(player == 2) {
//        	if(location.equals("battle")) {
//        		cardBattleBText[position].setText("???");
//        		cardBattleB[position].setFill(Color.TRANSPARENT);
//        		objectCardBattleB[position] = new CardViewerBattle();
//        	} else if(location.equals("draw")) {
//        		cardDrawBText[position].setText("???");
//        		cardDrawB[position].setFill(Color.TRANSPARENT);
//        		objectCardDrawB[position] = new CardViewer();
//        	}
//    	}
//
//    }

//    @FXML
//    void viewCard(MouseEvent event) {
//    	String id = ((Node) event.getSource()).getId();
//        
//        char type = id.charAt(4);
//        char player = '0';
//        int box = 0;
//        
//        if(type == 'D') {
//        	box = Integer.parseInt(id.substring(9,id.length()));
//        	player = id.charAt(8);
//        }
//        else if(type == 'B') {
//        	box = Integer.parseInt(id.substring(11,id.length()));
//        	player = id.charAt(10);
//        }
//        
//        if(player == 'A') {
//        	if(type == 'D') {
//            	if(objectCardDrawA[box].getAda() && state.getTurn() == 1) {
//                	cardViewImage.setImage(new Image("file:".concat(objectCardDrawA[box].getCard().getPath())));
//                	cardViewName.setText(objectCardDrawA[box].getCard().getName());
//                	cardViewId.setText(objectCardDrawA[box].getCard().getElement().toString());
//                	cardViewDescription.setText(objectCardDrawA[box].getCard().getDesc());
//                	System.out.println("file:".concat(objectCardDrawA[box].getCard().getPath())); //debug
//            	}
//        	} else if(type == 'B') {
//            	if(objectCardBattleA[box].getAda() && state.getTurn() == 1) {
//                	cardViewImage.setImage(new Image("file:".concat(objectCardBattleA[box].getCard().getPath())));
//                	cardViewName.setText(objectCardBattleA[box].getCard().getName());
//                	cardViewId.setText(objectCardBattleA[box].getCard().getElement().toString());
//                	cardViewDescription.setText(objectCardBattleA[box].getCard().getDesc());
//                	System.out.println(id); //debug
//            	}
//        	}
//        	
//        } else if(player == 'B') {
//        	if(type == 'D') {
//            	if(objectCardDrawB[box].getAda() && state.getTurn() == 2) {
//                	cardViewImage.setImage(new Image("file:".concat(objectCardDrawB[box].getCard().getPath())));
//                	cardViewName.setText(objectCardDrawB[box].getCard().getName());
//                	cardViewId.setText(objectCardDrawB[box].getCard().getElement().toString());
//                	cardViewDescription.setText(objectCardDrawB[box].getCard().getDesc());
//                 	System.out.println(id); //debug
//            	}
//        	} else if(type == 'B') {
//            	if(objectCardBattleB[box].getAda() && state.getTurn() == 2) {
//                	cardViewImage.setImage(new Image("file:".concat(objectCardBattleB[box].getCard().getPath())));
//                	cardViewName.setText(objectCardBattleB[box].getCard().getName());
//                	cardViewId.setText(objectCardBattleB[box].getCard().getElement().toString());
//                	cardViewDescription.setText(objectCardBattleB[box].getCard().getDesc());
//                	System.out.println(id); //debug
//            	}
//        	}
//        }
//    }

}
