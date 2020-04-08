package com.avatarduel.state;

import com.avatarduel.cards.*;
import java.util.*;
import com.avatarduel.model.Element;

public class Decks{
    private List<Card> hand;
    private List<Card> field;
    private Stack<Card> deck;
    
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

    public Card drawCard(){
        Card c = this.deck.pop();
        this.hand.add(c);
        return c;
    }
    
    public void addToDeck(Card c){
        this.deck.add(c);
    }
    
    // public void addToHand(){
        
    // }

    public void addToField(int pos){
    	if(this.field.size() < 16) {
            Card sc = this.hand.get(pos);
            this.hand.remove(pos);
            this.field.add(sc);
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
