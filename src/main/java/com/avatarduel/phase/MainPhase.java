package com.avatarduel.phase;

import com.avatarduel.state.*;
import com.avatarduel.model.Element;

public class MainPhase extends Phase {

    public MainPhase(){

        /* reset power atau enggak */
        resetPower = false;

        /* bisa draw atau enggak */
        canDraw = false;

        /* bisa pakai kartu atau enggak */
        canUseCard = true;

        /* tombol apa saja yang bisa di klik */
        drawBtn = false;
        mainBtn = false;
        battleBtn = true;
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
