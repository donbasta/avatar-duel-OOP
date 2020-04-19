package com.avatarduel.phase;

/**
 * DrawPhase implements the draw phase 
 * of the game
 *
 * @author 
 */
public class DrawPhase extends Phase {

    public DrawPhase(){

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
