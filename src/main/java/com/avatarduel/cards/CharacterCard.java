package com.avatarduel.cards;

import com.avatarduel.model.Element;

public class CharacterCard extends Card {

    private int attack;
    private int defense;
    private int power;
    private boolean hasAttacked;
    private String position; /* "ATTACK" or "DEFENSE" */

    public CharacterCard(String name, String desc, Element element, int attack, int defense, int power, String path){
        super(name, desc, element, path);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
        this.hasAttacked = false;
        this.position = "ATTACK";
    }

    public int getAttack(){
        return this.attack;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getPower(){
        return this.power;
    }
    
    public boolean getHasAttacked() { 
    	return this.hasAttacked;
    }

    public void setHasAttacked() {
    	this.hasAttacked = true;
    }

    public String getPosition() {
    	return this.position;
    }

    public void setPosition(String position) {
    	this.position = position;
    }
}