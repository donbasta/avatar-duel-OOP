package com.avatarduel.phase;

/**
 * BattlePhase implements the battle phase 
 * of the game
 *
 * @author 
 */
import com.avatarduel.state.*;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.exceptions.*;

public class BattlePhase extends Phase {

    public BattlePhase(){
        //this.decks = deck;


        /* reset power atau enggak */
        resetPower = false;

        /* bisa draw atau enggak */
        canDraw = false;

        /* bisa pakai kartu atau enggak */
        canUseCard = false;

        canAttack = true;

        skillActive = false;
        
        attackActive = false;

        destroyActive = false;

        /* tombol apa saja yang bisa di klik */
        drawBtn = false;
        mainBtn = false;
        battleBtn = false;
        endturnBtn = true;

    }
    
    public boolean attack(CharacterCard enemyCard, Player opponent) throws Exception {
    	
    	boolean enemyRemoved = false;
    	
        // Jika kartu sudah digunakan meenyerang, tidak bisa, dan melempar exception AlreadyAttackedException
        if (this.activeAttackingCard.getHasAttacked()){
            throw new AlreadyAttackedException();
        }
        // Jika kartu belum digunakan untuk menyerang, cek kondisi selanjutnya
        else {
            // Jika Posisi kartu kita dalam posisi bertahan, maka akan dikeluarkan exception bahwa tidak bisa menyerang dengan posisi kartu kita bertahan
            if (this.activeAttackingCard.getPosition().equals("DEFENSE")){
                throw new DefenseModeException();
            }
            // Jika posisi kartu kita dalam kondisi menyerang, cek kondisi selanjutnya
            else if (this.activeAttackingCard.getPosition().equals("ATTACK")) {
                // Jika posisi kartu musuh adalah menyerang, maka mengecek kondisi besar mana attack kartu kita dan musuh
                if (enemyCard.getPosition().equals("ATTACK")) {
                    // Jika nilai attack kartu kita lebih besar daripada kartu musuh, maka kartu musuh dihilangkan
                    if (this.activeAttackingCard.getAttack() > enemyCard.getAttack()) {
                    	this.activeAttackingCard.setHasAttacked();
                    	enemyRemoved = true;
//                      opponent.removePlayerCardFromField(enemyCard);
                        opponent.setHealth(opponent.getHealth() - (this.activeAttackingCard.getAttack() - enemyCard.getAttack()));
                    }
                    // Jika nilai attack kartu kita lebih kecil daripada kartu musuh, maka dikeluarkan exception StrongerEnemyCardException
                    else {
                        throw new StrongerEnemyCardException();
                    }
                }
                // Jika posisi kartu musuh dalam kondisi bertahan, maka mengecek kondisi selanjutnya
                else {
                	this.activeAttackingCard.setHasAttacked();
                    // Jika nilai attack kartu kita lebih besar daripada defense kartu musuh, maka kartu musuh dihilangkan
                    if (this.activeAttackingCard.getAttack() > enemyCard.getDefense()) {
                    	this.activeAttackingCard.setHasAttacked();
                    	enemyRemoved = true;
//                      opponent.removePlayerCardFromField(enemyCard);
                    }
                    // Jika nilai attack kartu kita lebih kecil daripada defense kartu musuh, maka dikeluarkan exception StrongerEnemyCardException
                    else {
                        throw new StrongerEnemyCardException();
                    }
                }
            }
        }
		return enemyRemoved;
    }

    /*
     * If there are no monsters on the field, the monster can attack the opponent's lifepoints directly. The monster's attack points are subtracted from the
     * opponent's lifepoints.
     */
    public void attackDirectly(Player opponent) throws Exception {
        // Jika sudah pernah dipakai menyerang, keluarkan exception
        if (this.activeAttackingCard.getHasAttacked()){
            throw new AlreadyAttackedException();
        }
        // Jika belum pernah dipakai menyerang
        else {
            // Jika posisi kartu dalam kondisi attack, kurangi life point musuh
            if (this.activeAttackingCard.getPosition().equals("ATTACK")) {
            	this.activeAttackingCard.setHasAttacked();
                opponent.setHealth(opponent.getHealth() - this.activeAttackingCard.getAttack());
            }
            // Jika tidak, keluarkan exception DefenseModeException
            else if (this.activeAttackingCard.getPosition().equals("DEFENSE")){
                throw new DefenseModeException();
            }
        }
    }

}
