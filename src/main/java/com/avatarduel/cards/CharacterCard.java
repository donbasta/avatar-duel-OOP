package com.avatarduel.cards;

import com.avatarduel.model.Element;

public class CharacterCard extends Card {

    private int attack;
    private int defense;
    private int power;
    private boolean haveAttacked;
    private String mode; /* "ATTACK" or "DEFENSE" */

    public CharacterCard(String name, String desc, Element element, int attack, int defense, int power,String path){
        super(name, desc, element, path);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
        this.haveAttacked = false;
        this.mode = "ATTACK";
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

    public boolean getHaveAttacked() { return this.haveAttacked;}

    public void setHaveAttacked() { this.haveAttacked = true;}

    public String getMode() { return this.mode;}

    public void setMode(String mode) { this.mode = mode;}
}