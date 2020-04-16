package com.avatarduel.phase;
import com.avatarduel.cards.*;
import com.avatarduel.state.*;
import com.avatarduel.exceptions.*;

public class BattlePhase implements Phase {
    /*Attribute*/
    private Player opponent;

    /*Constructor*/
    public BattlePhase(Player opponent) {
        this.opponent = opponent;
    }

    /*Method-method*/

    /*
     * A card can only attack an opponent's card if it is in ATTACK position and if the player is in BATTLE PHASE.
     * If the player's card has a higher attack than the opponent's card and both card are in ATTACK position,
     * the opponent's card is removed from the field and the difference between the player's card's attack points
     * and the opponent's card's attack points is subtracted from the opponent's lifepoints. If the opponent's card
     * is in defense mode, the card is removed without the opponent losing any lifepoints.
     */
    public void attack(CharacterCard myCard, CharacterCard enemyCard) throws DefenseModeException, AlreadyAttackedException, StrongerEnemyCardException {
        // Jika kartu sudah digunakan meenyerang, tidak bisa, dan melempar exception AlreadyAttackedException
        if (myCard.getHaveAttacked()){
            throw new AlreadyAttackedException();
        }
        // Jika kartu belum digunakan untuk menyerang, cek kondisi selanjutnya
        else {
            // Jika Posisi kartu kita dalam posisi bertahan, maka akan dikeluarkan exception bahwa tidak bisa menyerang dengan posisi kartu kita bertahan
            if (myCard.getMode().equals("DEFENSE")){
                throw new DefenseModeException();
            }
            // Jika posisi kartu kita dalam kondisi menyerang, cek kondisi selanjutnya
            else if (myCard.getMode().equals("ATTACK")) {
                // Jika posisi kartu musuh adalah menyerang, maka mengecek kondisi besar mana attack kartu kita dan musuh
                if (enemyCard.getMode().equals("ATTACK")) {
                    // Jika nilai attack kartu kita lebih besar daripada kartu musuh, maka kartu musuh dihilangkan
                    if (myCard.getAttack() > enemyCard.getAttack()) {
                        myCard.setHaveAttacked();
                        opponent.removePlayerCardFromField(enemyCard);
                        opponent.setHealth(opponent.getHealth() - (myCard.getAttack() - enemyCard.getAttack()));
                    }
                    // Jika nilai attack kartu kita lebih kecil daripada kartu musuh, maka dikeluarkan exception StrongerEnemyCardException
                    else {
                        throw new StrongerEnemyCardException();
                    }
                }
                // Jika posisi kartu musuh dalam kondisi bertahan, maka mengecek kondisi selanjutnya
                else {
                    myCard.setHaveAttacked();
                    // Jika nilai attack kartu kita lebih besar daripada defense kartu musuh, maka kartu musuh dihilangkan
                    if (myCard.getAttack() > enemyCard.getDefense()) {
                        myCard.setHaveAttacked();
                        opponent.removePlayerCardFromField(enemyCard);
                    }
                    // Jika nilai attack kartu kita lebih kecil daripada defense kartu musuh, maka dikeluarkan exception StrongerEnemyCardException
                    else {
                        throw new StrongerEnemyCardException();
                    }
                }
            }
        }
    }

    /*
     * If there are no monsters on the field, the monster can attack the opponent's lifepoints directly. The monster's attack points are subtracted from the
     * opponent's lifepoints.
     */
    public void attackDirectly(CharacterCard myCard) throws AlreadyAttackedException, DefenseModeException {
        // Jika sudah pernah dipakai menyerang, keluarkan exception
        if (myCard.getHaveAttacked()){
            throw new AlreadyAttackedException();
        }
        // Jika belum pernah dipakai menyerang
        else {
            // Jika posisi kartu dalam kondisi attack, kurangi life point musuh
            if (myCard.getMode().equals("ATTACK")) {
                myCard.setHaveAttacked();
                opponent.setHealth(opponent.getHealth() - myCard.getAttack());
            }
            // Jika tidak, keluarkan exception DefenseModeException
            else if (myCard.getMode().equals("DEFENSE")){
                throw new DefenseModeException();
            }
        }
    }

    @Override
    public void run() {
        
    }
}
