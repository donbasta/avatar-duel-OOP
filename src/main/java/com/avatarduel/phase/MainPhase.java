package com.avatarduel.phase;

/**
 * Mainphase implements the main phase 
 * of the game
 *
 * @author 
 */
public class MainPhase extends Phase {
	
	private boolean canUseLandCard;

    public MainPhase(){

        /* reset power atau enggak */
        resetPower = false;

        /* bisa draw atau enggak */
        canDraw = false;
        
        /* bisa remove atau enggak */
        canRemove = true;

        /* bisa pakai kartu atau enggak */
        canUseCard = true;
        
        /* masih bisa pake kartu land card atau nggak */
        canUseLandCard = true;

        canAttack = false;
        
        attackActive = false;

        skillActive = false;

        destroyActive = false;

        /* tombol apa saja yang bisa di klik */
        drawBtn = false;
        mainBtn = false;
        battleBtn = true;
        endturnBtn = false;

    }
    
    public boolean getCanUseLandCard() {
    	return this.canUseLandCard;
    }
    
    public void setLandCardUsed() {
    	this.canUseLandCard = false;
    }

}
