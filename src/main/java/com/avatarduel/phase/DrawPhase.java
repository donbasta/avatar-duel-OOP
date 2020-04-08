package com.avatarduel.phase;

import com.avatarduel.state.*;
import com.avatarduel.model.Element;

public class DrawPhase implements Phase{
    private int turn;
    private Decks decks;
    private Power power;

    public DrawPhase(int turn, Decks deck){
        this.turn = turn;
        this.decks = deck;
    }

    public void run(){
        int fire = this.decks.countLand(Element.FIRE);
        int water = this.decks.countLand(Element.WATER);
        int air = this.decks.countLand(Element.AIR);
        int earth = this.decks.countLand(Element.EARTH);
        this.power = new Power(fire,water,air,earth);
        this.decks.drawCard();
    }

}
