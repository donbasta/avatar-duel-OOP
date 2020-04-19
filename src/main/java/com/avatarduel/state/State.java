package com.avatarduel.state;

import com.avatarduel.phase.*;

/**
 * State is an object responsible
 * for keeping the current state of
 * the game, including the information
 * of whose turn is it currently and 
 * the phase.
 *
 * @author 
 */
public class State {
    private int turn;

    private Phase phase;

    public State(int turn, Player P1, Player P2, Phase ph){
        this.turn = turn;
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

}
