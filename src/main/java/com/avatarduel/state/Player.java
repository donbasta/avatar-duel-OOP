package com.avatarduel.state;

import com.avatarduel.model.Element;

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
    
    public void setPowerToDefault() {
    	this.getPower().fullPower();
    }
    
    public void incrementPower(Element element) {
    	this.getPower().addPower(element);
    }

    public void usePower(Element element, int change){
        this.getPower().usePower(element, change);
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