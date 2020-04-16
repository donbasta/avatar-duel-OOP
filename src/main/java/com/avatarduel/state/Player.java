package com.avatarduel.state;

import java.util.*;
import com.avatarduel.cards.*;

public class Player{
    private int health;
    private Decks cards;
    private Power power;
    
    final private int MAX_HEALTH = 80;
    
    public Player(){
        this.health = MAX_HEALTH;
        this.cards = new Decks();
        this.power = new Power();
    }
    
    public Decks getDecks() {
    	return this.cards;
    }

    public int getHealth(){
        return this.health;
    }
    
    public Power getPower() {
    	return this.power;
    }
    
    public void setHealth(int health){
        if(health < 0){
            this.health = 0;
        }
        else{
            this.health = health;
        }
    }

    public void removePlayerCardFromField(Card Card) {
        cards.removeFromField(Card);
    }
}