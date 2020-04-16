package com.avatarduel.cards;

import com.avatarduel.model.Element;

public class SkillCard extends Card {

    private String type;
    private int power;
    private int incatk;
    private int incdef;

    public SkillCard(String name, String desc, Element element, String type, int power, int incatk, int incdef, String path){
        super(name, desc, element, path);
        this.type = type;
        this.power = power;
        this.incatk = incatk;
        this.incdef = incdef;
    }

    public String getType(){
        return this.type;
    }

    public int getAttackIncrease(){
        return this.incatk;
    }

    public int getDefenseIncrease(){
        return this.incdef;
    }

    public int getPower(){
        return this.power;
    }

}