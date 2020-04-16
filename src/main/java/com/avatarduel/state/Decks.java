package com.avatarduel.state;

import com.avatarduel.cards.*;
import java.util.*;
import com.avatarduel.model.Element;
import com.avatarduel.exceptions.*;

public class Decks{
    private List<Card> hand;
    private List<Card> field;
    private Stack<Card> deck;
    final int MAKS_HAND = 8;
    
    public Decks(){
        this.hand = new ArrayList<Card>();
        this.field = new ArrayList<Card>();
        this.deck = new Stack<Card>();
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public List<Card> getField(){
        return this.field;
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
    
    public void addToDeck(Card c){
        this.deck.add(c);
    }
    
    // public void addToHand(){
        
    // }

    public void addToField(Card c){
    	if(this.field.size() < 16) {
            this.hand.remove(c);
            this.field.add(c);
    	}        
    }

    public void removeFromField(Card card){
    	if(this.field.contains(card)) {
    		this.field.remove(this.field.indexOf(card));
    	} else{
            System.out.println("Card is not in the field");
        }
    }

    public int countLand(Element element){
        int count = 0;
        for (int i=0; i<this.hand.size(); i++){
            if (this.hand.get(i).getElement() == element){
                count++;
            }
        }
        return count;
    }

}
