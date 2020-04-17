package com.avatarduel.phase;

import com.avatarduel.state.*;
import com.avatarduel.cards.*;
import com.avatarduel.exceptions.LandCardException;
import com.avatarduel.exceptions.CharacterFullException;
/*
public class MainPhase1 implements Phase{
    private int turn;
    private Decks player;
    private Power power;
    private boolean cek_putland;
    private boolean skill_active;

    public MainPhase1(int turn, Decks player, Power power){
        this.turn = turn;
        this.player = player;
        this.power = power;
        this.cek_putland = true;
        this.skill_active = false;
    }

    public void putCardToField(Card c) throws Exception{
    	
        if (c.getClass().getSimpleName()=="LandCard"){
            if (this.cek_putland){
                this.player.addToField(c);
                this.cek_putland = false;
            }
            else{
            	throw new LandCardException();
            }
        }
        else if (c.getClass().getSimpleName() == "SkillCard"){
        	this.skill_active = true;
        }
        else if (c.getClass().getSimpleName() == "CharacterCard"){
        	CharacterCard cc = (CharacterCard) c;
            if (this.power.getPower(cc.getElement()) - cc.getPower() >=0){
                this.player.addToField(cc);
                this.power.setPower(cc.getElement(), this.power.getPower(cc.getElement())-cc.getPower());
            }
            else{
            	throw new NotEnoughPowerException();
            }
        }
    }

    public void throwSkill(Card c){
        if(c.getClass().getSimpleName() == "SkillCard"){
            this.player.removeFromField(c);
        }
        else{
            System.out.println("This is not a skill card");
        }
    }

    public void run(){
        boolean running = true;
        int aksi = 0;
        while(true){
            Card c;
            if (aksi == 1){
//                putCardToField(c);

            }
            else if(aksi==2){
//                moveCard(c,0);
            }
            else{
//                throwSkill(c);
            }
        }
    }

}
*/