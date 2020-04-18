package com.avatarduel.state;

import com.avatarduel.cards.*;
import java.util.*;
import com.avatarduel.model.Element;
import com.avatarduel.exceptions.*;

public class Decks{
    private List<Card> hand;
    private List<Card> skillCard;
    private List<Card> characterCard;
    private Stack<Card> deck;
    final int MAKS_HAND = 9;
    final int MAKS_CHARACTER_CARD = 6;
    final int MAKS_SKILL_CARD = 6;
    
    public Decks(){
        this.hand = new ArrayList<Card>();
        this.characterCard = new ArrayList<Card>();
        this.skillCard = new ArrayList<Card>();
        this.deck = new Stack<Card>();
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public List<Card> getSkillCard(){
        return this.skillCard;
    }
    
    public List<Card> getCharacterCard(){
    	return this.characterCard;
    }

    public Stack<Card> getDeck(){
        return this.deck;
    }

    public Card drawCard() throws Exception{
    	if(hand.size() == MAKS_HAND) {
    		throw new HandFullException();
    	}
        Card c = this.deck.pop();
        this.hand.add(c);
        return c;
    }
    
    public void removeCardFromHand(Card card) {
    	this.hand.remove(card);
    }
    
    public void removeCardFromField(Card card) {
    	if(card.getClass().getSimpleName().equals("SkillCard")) {
    		this.skillCard.remove(card);
    	} else if(card.getClass().getSimpleName().equals("CharacterCard")) {
    		this.characterCard.remove(card);
    	}
    }
    
    public void addToDeck(Card c){
        this.deck.add(c);
    }

    public void addToFieldCharacter(CharacterCard c, Power power) throws Exception{
    	if(this.characterCard.size() == MAKS_CHARACTER_CARD) {
    		throw new CharacterFullException();
    	}
        Element e = c.getElement();
    	if(power.getPower(e) < c.getPower()) {
    		throw new NotEnoughPowerException();
    	}
    	
    	power.usePower(c.getElement(), c.getPower());
        this.hand.remove(c);
        this.characterCard.add(c);
    }
    
    public void useLand(Card c) {
    	this.hand.remove(c);
    }
    
    public void addToFieldSkill(SkillCard c, Power power) throws Exception{
    	if(this.skillCard.size() == MAKS_SKILL_CARD) {
    		throw new SkillFullException();
    	}
    	
    	if(power.getPower(c.getElement()) == 0) {
    		throw new NotEnoughPowerException();
    	}
    	
    	//sekarang update flag2 nya buat skill, pilih kartu
    	
    	power.usePower(c.getElement(), c.getPower());
        this.hand.remove(c);
        this.characterCard.add(c);
    }

}
