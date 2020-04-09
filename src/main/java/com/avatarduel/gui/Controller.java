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
import javafx.scene.control.Button;

public class Controller {

	@FXML
    private Pane mainPane;

    @FXML
    private Text cardViewName;

    @FXML
    private Text cardViewId;

    @FXML
    private ImageView cardViewImage;
    
    @FXML
    private Text cardViewDescription;

    @FXML
    private Rectangle cardBattleA9;

    @FXML
    private Text cardBattleA9Text;

    @FXML
    private Rectangle cardBattleA10;

    @FXML
    private Text cardBattleA10Text;

    @FXML
    private Rectangle cardBattleA11;

    @FXML
    private Text cardBattleA11Text;

    @FXML
    private Rectangle cardBattleA12;

    @FXML
    private Text cardBattleA12Text;

    @FXML
    private Rectangle cardBattleA13;

    @FXML
    private Text cardBattleA13Text;

    @FXML
    private Rectangle cardBattleA14;

    @FXML
    private Text cardBattleA14Text;

    @FXML
    private Rectangle cardBattleA15;

    @FXML
    private Text cardBattleA15Text;

    @FXML
    private Rectangle cardBattleA16;

    @FXML
    private Text cardBattleA16Text;

    @FXML
    private Rectangle cardBattleB9;

    @FXML
    private Text cardBattleB9Text;

    @FXML
    private Rectangle cardBattleB10;

    @FXML
    private Text cardBattleB10Text;

    @FXML
    private Rectangle cardBattleB11;

    @FXML
    private Text cardBattleB11Text;

    @FXML
    private Rectangle cardBattleB12;

    @FXML
    private Text cardBattleB12Text;

    @FXML
    private Rectangle cardBattleB13;

    @FXML
    private Text cardBattleB13Text;

    @FXML
    private Rectangle cardBattleB14;

    @FXML
    private Text cardBattleB14Text;

    @FXML
    private Rectangle cardBattleB15;

    @FXML
    private Text cardBattleB15Text;

    @FXML
    private Rectangle cardBattleB16;

    @FXML
    private Text cardBattleB16Text;

    @FXML
    private Rectangle cardBattleB1;

    @FXML
    private Text cardBattleB1Text;

    @FXML
    private Rectangle cardBattleB2;

    @FXML
    private Text cardBattleB2Text;

    @FXML
    private Rectangle cardBattleB3;

    @FXML
    private Text cardBattleB3Text;

    @FXML
    private Rectangle cardBattleB4;

    @FXML
    private Text cardBattleB4Text;

    @FXML
    private Rectangle cardBattleB5;

    @FXML
    private Text cardBattleB5Text;

    @FXML
    private Rectangle cardBattleB6;

    @FXML
    private Text cardBattleB6Text;

    @FXML
    private Rectangle cardBattleB7;

    @FXML
    private Text cardBattleB7Text;

    @FXML
    private Rectangle cardBattleB8;

    @FXML
    private Text cardBattleB8Text;

    @FXML
    private Rectangle cardDrawB1;

    @FXML
    private Text cardDrawB1Text;

    @FXML
    private Rectangle cardDrawB2;

    @FXML
    private Text cardDrawB2Text;

    @FXML
    private Rectangle cardDrawB3;

    @FXML
    private Text cardDrawB3Text;

    @FXML
    private Rectangle cardDrawB4;

    @FXML
    private Text cardDrawB4Text;

    @FXML
    private Rectangle cardDrawB5;

    @FXML
    private Text cardDrawB5Text;

    @FXML
    private Rectangle cardDrawB6;

    @FXML
    private Text cardDrawB6Text;

    @FXML
    private Rectangle cardDrawB7;

    @FXML
    private Text cardDrawB7Text;
    
    @FXML
    private Rectangle cardDrawB8;

    @FXML
    private Text cardDrawB8Text;

    @FXML
    private Rectangle cardBattleA1;

    @FXML
    private Text cardBattleA1Text;

    @FXML
    private Rectangle cardBattleA2;

    @FXML
    private Text cardBattleA2Text;

    @FXML
    private Rectangle cardBattleA3;

    @FXML
    private Text cardBattleA3Text;

    @FXML
    private Rectangle cardBattleA4;

    @FXML
    private Text cardBattleA4Text;

    @FXML
    private Rectangle cardBattleA5;

    @FXML
    private Text cardBattleA5Text;

    @FXML
    private Rectangle cardBattleA6;

    @FXML
    private Text cardBattleA6Text;

    @FXML
    private Rectangle cardBattleA7;

    @FXML
    private Text cardBattleA7Text;

    @FXML
    private Rectangle cardBattleA8;

    @FXML
    private Text cardBattleA8Text;

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
    private Rectangle cardDrawA8;

    @FXML
    private Text cardDrawA8Text;

    @FXML
    private Rectangle deck1;

    @FXML
    private Rectangle deck2;
    
    @FXML
    private Text numCardDeck1;

    @FXML
    private Text numCardDeck2;

	@FXML
	private Text status;

	@FXML
	private Button btn_draw;
	@FXML
	private Button btn_mp1;
	@FXML
	private Button btn_battle;
	@FXML
	private Button btn_mp2;
	@FXML
	private Button btn_et;

	@FXML 
	private Text water1;

	@FXML 
	private Text air1;

	@FXML 
	private Text earth1;

	@FXML 
	private Text fire1;
    
	@FXML 
	private Text water2;

	@FXML 
	private Text air2;

	@FXML 
	private Text earth2;

	@FXML 
	private Text fire2;

    protected Rectangle[] cardDrawA;
    protected Rectangle[] cardDrawB;
    protected Rectangle[] cardBattleA;
    protected Rectangle[] cardBattleB;
    protected Text[] cardDrawAText;
    protected Text[] cardDrawBText;
    protected Text[] cardBattleAText;
    protected Text[] cardBattleBText;
    protected CardViewer[] objectCardDrawA;
    protected CardViewer[] objectCardDrawB;
    protected CardViewer[] objectCardBattleA;
    protected CardViewer[] objectCardBattleB;
    protected Text[] numCardDeck;
    
    protected Player hojun;
    protected Player qila;
    protected State state;
    protected int maksKartu;
    protected MainPhase1 mainphase;
	private int te;
    
    public void setPlay(Player pa, Player pb, State st) {
    	hojun = pa;
    	qila = pb;
    	state = st;
    	
    	maksKartu = state.getPlayer(1).getDecks().getDeck().size();
    	
    	hideCard(1);
    	hideCard(2);

		btn_draw.setDisable(true);
		btn_mp1.setDisable(true);
    	btn_battle.setDisable(true);
		btn_mp2.setDisable(true);
		btn_et.setDisable(true);
		deck2.setDisable(true);

		status.setText("Player 1 : Draw Phase");
    	Card cd;
    	for(int i=1; i<=7; i++) {
    		try {
				cd = state.getPlayer(1).getDecks().drawCard();
				addCard(1,cd);
	    		cd = state.getPlayer(2).getDecks().drawCard();
	    		addCard(2,cd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

		this.setPower(1, state.getPlayer(1));
		this.setPower(2, state.getPlayer(2));
		


    	hideCard(2);
    	numCardDeck1.setText(String.format("%d / %d", state.getPlayer(1).getDecks().getDeck().size(), maksKartu));
    	numCardDeck2.setText(String.format("%d / %d", state.getPlayer(2).getDecks().getDeck().size(), maksKartu));
    	

    }

	private void setPower(int who, Player p){
		if(who == 1){
			air1.setText(Integer.toString(p.getPower().getPower(Element.AIR)));
			water1.setText(Integer.toString(p.getPower().getPower(Element.WATER)));
			earth1.setText(Integer.toString(p.getPower().getPower(Element.EARTH)));
			fire1.setText(Integer.toString(p.getPower().getPower(Element.FIRE)));
		} else {
			air2.setText(Integer.toString(p.getPower().getPower(Element.AIR)));
			water2.setText(Integer.toString(p.getPower().getPower(Element.WATER)));
			earth2.setText(Integer.toString(p.getPower().getPower(Element.EARTH)));
			fire2.setText(Integer.toString(p.getPower().getPower(Element.FIRE)));
		}
	}



    @FXML
    public void initialize() {
    	
    	System.out.println("test cuy"); //debug
    	Scene scene = mainPane.getScene();
   
    	cardDrawA = new Rectangle[10];
    	cardDrawA[1] = cardDrawA1;
    	cardDrawA[2] = cardDrawA2;
    	cardDrawA[3] = cardDrawA3;
    	cardDrawA[4] = cardDrawA4;
    	cardDrawA[5] = cardDrawA5;
    	cardDrawA[6] = cardDrawA6;
    	cardDrawA[7] = cardDrawA7;
    	cardDrawA[8] = cardDrawA8;
    	
    	cardBattleA = new Rectangle[17];
    	cardBattleA[1] = cardBattleA1;
    	cardBattleA[2] = cardBattleA2;
    	cardBattleA[3] = cardBattleA3;
    	cardBattleA[4] = cardBattleA4;
    	cardBattleA[5] = cardBattleA5;
    	cardBattleA[6] = cardBattleA6;
    	cardBattleA[7] = cardBattleA7;
    	cardBattleA[8] = cardBattleA8;
    	cardBattleA[9] = cardBattleA9;
    	cardBattleA[10] = cardBattleA10;
    	cardBattleA[11] = cardBattleA11;
    	cardBattleA[12] = cardBattleA12;
    	cardBattleA[13] = cardBattleA13;
    	cardBattleA[14] = cardBattleA14;
    	cardBattleA[15] = cardBattleA15;
    	cardBattleA[16] = cardBattleA16;
    	
    	cardDrawAText = new Text[10];
    	cardDrawAText[1] = cardDrawA1Text;
    	cardDrawAText[2] = cardDrawA2Text;
    	cardDrawAText[3] = cardDrawA3Text;
    	cardDrawAText[4] = cardDrawA4Text;
    	cardDrawAText[5] = cardDrawA5Text;
    	cardDrawAText[6] = cardDrawA6Text;
    	cardDrawAText[7] = cardDrawA7Text;
    	cardDrawAText[8] = cardDrawA8Text;
    	
    	cardBattleAText = new Text[17];
    	cardBattleAText[1] = cardBattleA1Text;
    	cardBattleAText[2] = cardBattleA2Text;
    	cardBattleAText[3] = cardBattleA3Text;
    	cardBattleAText[4] = cardBattleA4Text;
    	cardBattleAText[5] = cardBattleA5Text;
    	cardBattleAText[6] = cardBattleA6Text;
    	cardBattleAText[7] = cardBattleA7Text;
    	cardBattleAText[8] = cardBattleA8Text;
    	cardBattleAText[9] = cardBattleA9Text;
    	cardBattleAText[10] = cardBattleA10Text;
    	cardBattleAText[11] = cardBattleA11Text;
    	cardBattleAText[12] = cardBattleA12Text;
    	cardBattleAText[13] = cardBattleA13Text;
    	cardBattleAText[14] = cardBattleA14Text;
    	cardBattleAText[15] = cardBattleA15Text;
    	cardBattleAText[16] = cardBattleA16Text;
    	
    	cardDrawB = new Rectangle[10];
    	cardDrawB[1] = cardDrawB1;
    	cardDrawB[2] = cardDrawB2;
    	cardDrawB[3] = cardDrawB3;
    	cardDrawB[4] = cardDrawB4;
    	cardDrawB[5] = cardDrawB5;
    	cardDrawB[6] = cardDrawB6;
    	cardDrawB[7] = cardDrawB7;
    	cardDrawB[8] = cardDrawB8;
    	
    	cardBattleB = new Rectangle[17];
    	cardBattleB[1] = cardBattleB1;
    	cardBattleB[2] = cardBattleB2;
    	cardBattleB[3] = cardBattleB3;
    	cardBattleB[4] = cardBattleB4;
    	cardBattleB[5] = cardBattleB5;
    	cardBattleB[6] = cardBattleB6;
    	cardBattleB[7] = cardBattleB7;
    	cardBattleB[8] = cardBattleB8;
    	cardBattleB[9] = cardBattleB9;
    	cardBattleB[10] = cardBattleB10;
    	cardBattleB[11] = cardBattleB11;
    	cardBattleB[12] = cardBattleB12;
    	cardBattleB[13] = cardBattleB13;
    	cardBattleB[14] = cardBattleB14;
    	cardBattleB[15] = cardBattleB15;
    	cardBattleB[16] = cardBattleB16;
    	
    	cardDrawBText = new Text[10];
    	cardDrawBText[1] = cardDrawB1Text;
    	cardDrawBText[2] = cardDrawB2Text;
    	cardDrawBText[3] = cardDrawB3Text;
    	cardDrawBText[4] = cardDrawB4Text;
    	cardDrawBText[5] = cardDrawB5Text;
    	cardDrawBText[6] = cardDrawB6Text;
    	cardDrawBText[7] = cardDrawB7Text;
    	cardDrawBText[8] = cardDrawB8Text;
    	
    	cardBattleBText = new Text[17];
    	cardBattleBText[1] = cardBattleB1Text;
    	cardBattleBText[2] = cardBattleB2Text;
    	cardBattleBText[3] = cardBattleB3Text;
    	cardBattleBText[4] = cardBattleB4Text;
    	cardBattleBText[5] = cardBattleB5Text;
    	cardBattleBText[6] = cardBattleB6Text;
    	cardBattleBText[7] = cardBattleB7Text;
    	cardBattleBText[8] = cardBattleB8Text;
    	cardBattleBText[9] = cardBattleB8Text;
    	cardBattleBText[10] = cardBattleB10Text;
    	cardBattleBText[11] = cardBattleB11Text;
    	cardBattleBText[12] = cardBattleB12Text;
    	cardBattleBText[13] = cardBattleB13Text;
    	cardBattleBText[14] = cardBattleB14Text;
    	cardBattleBText[15] = cardBattleB15Text;
    	cardBattleBText[16] = cardBattleB16Text;
    	
    	objectCardDrawA = new CardViewer[10];
    	for(int i=1; i<=8; i++) {
    		objectCardDrawA[i] = new CardViewer();
    	}
    	
    	objectCardBattleA = new CardViewerBattle[17];
    	for(int i=1; i<17; i++) {
    		objectCardBattleA[i] = new CardViewerBattle();
    	}
    	
    	objectCardDrawB = new CardViewer[10];
    	for(int i=1; i<=8; i++) {
    		objectCardDrawB[i] = new CardViewer();
    	}
    	
    	objectCardBattleB = new CardViewerBattle[17];
    	for(int i=1; i<17; i++) {
    		objectCardBattleB[i] = new CardViewerBattle();
    	}
    	
    	numCardDeck = new Text[3];
    	numCardDeck[1] = numCardDeck1;
    	numCardDeck[2] = numCardDeck2;

        cardViewImage.setImage(new Image("file:src/main/resources/com/avatarduel/card/image/land/Ba Sing Se.png"));
    	
    }

    @FXML
    void drawCard(MouseEvent event) {
		
    	int turn = state.getTurn();
    	Card drawn;
		try {
			drawn = state.getPlayer(turn).getDecks().drawCard();
	    	numCardDeck[turn].setText(String.format("%d / %d", state.getPlayer(turn).getDecks().getDeck().size(), maksKartu));
	    	addCard(turn, drawn);
		} catch (Exception e) {
			String t = e.toString();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void hideCard(int numPlayer) {
    	if(numPlayer == 1) {
        	for(int i=1; i<=8; i++) {
        		if(objectCardDrawA[i].getAda()) {
        			objectCardDrawA[i].setUp(false);
        			cardDrawA[i].setFill(Color.TRANSPARENT);
        		}
        		cardDrawAText[i].setText("???");
        	}
    	} else if(numPlayer == 2) {
    		for(int i=1; i<=8; i++) {
    			if(objectCardDrawB[i].getAda()) {
        			objectCardDrawB[i].setUp(false);
        			cardDrawB[i].setFill(Color.TRANSPARENT);
        		}
    			cardDrawBText[i].setText("???");
    		}
    	}
    }
    
    void showCard(int numPlayer) {
    	if(numPlayer == 1) {
        	for(int i=1; i<=8; i++) {
        		if(objectCardDrawA[i].getAda()) {
        			objectCardDrawA[i].setUp(true);
        			cardDrawAText[i].setText(getDescription(objectCardDrawA[i].getCard()));
        			cardDrawA[i].setFill(getColor(objectCardDrawA[i].getCard()));
        		}
        	}
    	} else if(numPlayer == 2) {
    		for(int i=1; i<=8; i++) {
    			if(objectCardDrawB[i].getAda()) {
        			objectCardDrawB[i].setUp(true);
        			cardDrawBText[i].setText(getDescription(objectCardDrawB[i].getCard()));
        			cardDrawB[i].setFill(getColor(objectCardDrawB[i].getCard()));
        		}
    		}
    	}
    }
    
    String getDescription(Card cd) {
    	String description = "";
		if(cd.getClass().getSimpleName().equals("LandCard")) {
			description = "LAND";
		} else if(cd.getClass().getSimpleName().equals("CharacterCard")) {
			CharacterCard chd = (CharacterCard) cd;
			description = String.format("PWR %d\nATK %d\nDEF %d", chd.getPower(), chd.getAttack(), chd.getDefense());
		} else if(cd.getClass().getSimpleName().equals("SkillCard")) {
			SkillCard scd = (SkillCard) cd;
			description = String.format("%s\nPWR %d\n ATK %d\n DEF %d", scd.getType(), scd.getPower(), scd.getAttackIncrease(), scd.getDefenseIncrease());
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
    
    void addCard(int numPlayer, Card cd) {
    	
    	if(numPlayer == 1) {
    		for(int i=1; i<=8; i++) {
        		if(objectCardDrawA[i].getAda()) {
        			continue;
        		}
        		objectCardDrawA[i] = new CardViewer(true, true, cd);
        		String description = getDescription(cd);
        		cardDrawA[i].setFill(getColor(cd));
            	cardDrawAText[i].setText(description);
            	break;
        	}
    	} else if(numPlayer == 2) {
    		for(int i=1; i<=8; i++) {
        		if(objectCardDrawB[i].getAda()) {
        			continue;
        		}
        		objectCardDrawB[i] = new CardViewer(true, true, cd);
        		String description = getDescription(cd);
        		cardDrawB[i].setFill(getColor(cd));
            	cardDrawBText[i].setText(description);
            	break;
        	}
    	}
    	
    }
    
    @FXML
    void mainPhaseCard(MouseEvent event) {
    	int turn = state.getTurn();
    	String id = ((Node) event.getSource()).getId();
    	int box = Integer.parseInt(id.substring(9,id.length()));
    	char player = id.charAt(8);
    	
    	System.out.println(player);
    	
    	if(player == 'A' && turn == 1) {
    		Card main = objectCardDrawA[box].getCard();
    		mainphase = new MainPhase1(1,state.getPlayer(1).getDecks(), state.getPlayer(1).getPower());
    		try {
				mainphase.putCardToField(main);
				putCardToBattle(main,turn);
				emptyCell("draw", turn, box);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} else if(player == 'B' && turn == 2) {
    		Card main = objectCardDrawB[box].getCard();
    		mainphase = new MainPhase1(2,state.getPlayer(2).getDecks(), state.getPlayer(2).getPower());
    		try {
				mainphase.putCardToField(main);
				putCardToBattle(main,turn);
				emptyCell("draw", turn, box);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}	
    }
    
    void putCardToBattle(Card c, int player) {
    	if(player == 1) {
        	for(int i = 1; i<=16; i++) {
        		if(objectCardBattleA[i].getAda()) {
        			continue;
        		}
        		objectCardBattleA[i] = new CardViewerBattle(true, true, c, 1);
        		String description = getDescription(c);
        		cardBattleA[i].setFill(getColor(c));
            	cardBattleAText[i].setText(description);
            	break;
        	}
    	}
    	if(player == 2) {
        	for(int i = 1; i<=16; i++) {
        		if(objectCardBattleB[i].getAda()) {
        			continue;
        		}
        		objectCardBattleB[i] = new CardViewerBattle(true, true, c, 1);
        		String description = getDescription(c);
        		cardBattleB[i].setFill(getColor(c));
            	cardBattleBText[i].setText(description);
            	break;
        	}
    	}

    }
    
    void emptyCell(String location, int player, int position) {
    	if(player == 1) {
        	if(location.equals("battle")) {
        		cardBattleAText[position].setText("???");
        		cardBattleA[position].setFill(Color.TRANSPARENT);
        		objectCardBattleA[position] = new CardViewerBattle();
        	} else if(location.equals("draw")) {
        		cardDrawAText[position].setText("???");
        		cardDrawA[position].setFill(Color.TRANSPARENT);
        		objectCardDrawA[position] = new CardViewer();
        	}
    	} else if(player == 2) {
        	if(location.equals("battle")) {
        		cardBattleBText[position].setText("???");
        		cardBattleB[position].setFill(Color.TRANSPARENT);
        		objectCardBattleB[position] = new CardViewerBattle();
        	} else if(location.equals("draw")) {
        		cardDrawBText[position].setText("???");
        		cardDrawB[position].setFill(Color.TRANSPARENT);
        		objectCardDrawB[position] = new CardViewer();
        	}
    	}

    }

    @FXML
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

}
