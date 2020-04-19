package com.avatarduel.cards;

import com.avatarduel.model.Element;
import java.util.ArrayList;
import com.avatarduel.gui.CardViewer;

public class CharacterCard extends Card {

    private int attack;
    private int defense;
    private int power;
    private boolean hasAttacked;
    private boolean powerup;
    private String position; /* "ATTACK" or "DEFENSE" */
    private ArrayList<CardViewer> equipped;

    public CharacterCard(String name, String desc, Element element, int attack, int defense, int power, String path){
        super(name, desc, element, path);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
        this.hasAttacked = true;
        this.position = "ATTACK";
        this.powerup = false;
        equipped = new ArrayList<CardViewer>();
    }

    public void useSkill(CardViewer a){
        equipped.add(a);
        SkillCard x = ((SkillCard) a.getCard());
        this.attack += x.getAttackIncrease();
        this.defense += x.getDefenseIncrease();
    }

    public ArrayList<CardViewer> getEquippedSkill(){
        return this.equipped;
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

    public void powerUp(CardViewer a){
        equipped.add(a);
        this.powerup = true;
    }

    public Boolean isPowerup(){
        return this.powerup;
    }

    public void resetHasAttacked(){
        this.hasAttacked = false;
    }

    public String getPosition() {
    	return this.position;
    }

    public void setPosition(String position) {
    	this.position = position;
    }
}