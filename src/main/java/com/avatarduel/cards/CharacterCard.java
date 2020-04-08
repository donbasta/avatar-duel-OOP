package com.avatarduel.cards;

import com.avatarduel.model.Element;

public class CharacterCard extends Card {

    private int attack;
    private int defense;
    private int power;

    public CharacterCard(String name, String desc, Element element, int attack, int defense, int power, String path){
        super(name, desc, element, path);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
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
}