package com.avatarduel.phase;


import com.avatarduel.state.*;

public class DrawPhase extends Phase {
    private Decks decks;
    private Power power;

    public DrawPhase(){
        //this.decks = deck;


        /* reset power atau enggak */
        resetPower = true;

        /* bisa draw atau enggak */
        canDraw = true;
        
        /* bisa remove atau enggak */
        canRemove = true;

        /* bisa pakai kartu atau enggak */
        canUseCard = false;

        canAttack = false;

        skillActive = false;
        
        attackActive = false;

        destroyActive = false;

        /* tombol apa saja yang bisa di klik */
        drawBtn = false;
        mainBtn = false;
        battleBtn = false;
        endturnBtn = false;

    }

}
