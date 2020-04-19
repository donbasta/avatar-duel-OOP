package com.avatarduel.state;

import com.avatarduel.phase.*;

public class State {
    private boolean run;
    private int turn;
    private Player P1;
    private Player P2;

    private Phase phase;

    public State(int turn, Player P1, Player P2, Phase ph){
        this.run = true;
        this.turn = turn;
        this.P1 = P1;
        this.P2 = P2;
        this.phase = ph;
    }

    public void setPhase(Phase a){
        this.phase = a;
    }

    public void changeTurn(){
        this.turn = (2 - this.turn) % 2 + 1;
    }
    public Phase getPhase(){
        return this.phase;
    }

    public int getTurn(){
        return this.turn;
    }
    
    public Player getPlayer(int a) {
    	if(a==1) return this.P1;
    	else if(a==2) return this.P2;
    	return new Player();
    }

    public void checkState(){
        if (this.P1.getHealth()==0 || this.P2.getHealth()==0){ //gameover
            this.run = false;
        }
    }

}
