package com.avatarduel.state;

import java.util.*;
import com.avatarduel.cards.*;

public class Player{
    private int health;
    private Decks cards;
    
    final private int MAX_HEALTH = 100;
    
    public Player(){
        this.health = MAX_HEALTH;
        this.cards = new Decks();
    }
    
    public Decks getDecks() {
    	return this.cards;
    }

    public int getHealth(){
        return this.health;
    }
    
    public void setHealth(int health){
        if(health < 0){
            this.health = 0;
        }
        else{
            this.health = health;
        }
    }
}