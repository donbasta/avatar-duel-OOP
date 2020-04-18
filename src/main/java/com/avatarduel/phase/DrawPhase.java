package com.avatarduel.phase;


import com.avatarduel.state.*;
import com.avatarduel.model.Element;

public class DrawPhase extends Phase {
    private Decks decks;
    private Power power;

    public DrawPhase(){
        //this.decks = deck;


        /* reset power atau enggak */
        resetPower = true;

        /* bisa draw atau enggak */
        canDraw = true;

        /* bisa pakai kartu atau enggak */
        canUseCard = false;

        canAttack = false;

        skillActive = false;

        destroyActive = false;

        /* tombol apa saja yang bisa di klik */
        drawBtn = false;
        mainBtn = false;
        battleBtn = false;
        endturnBtn = false;

    }

    /* void run(){
        int fire = this.decks.countLand(Element.FIRE);
        int water = this.decks.countLand(Element.WATER);
        int air = this.decks.countLand(Element.AIR);
        int earth = this.decks.countLand(Element.EARTH);
        this.power = new Power(fire,water,air,earth);
        try {
			this.decks.drawCard();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }*/

}
