import java.util.*;

abstract class State {
    private boolean run;
    private int turn;
    private Player P1;
    private Player P2;
    private int phase;
    // private List FieldP1;
    // private List FieldP2;
    // private List DeckP1;
    // private List DeckP2;

    public State(int turn, Player P1,Player P2,Phase current,List FieldP1, List FieldP2, List DeckP1, List DeckP2){
        this.run = true;
        this.turn = turn;
        this.P1 = P1;
        this.P2 = P2;
        this.current = current;
        this.FieldP1 = FieldP1;
        this.FieldP2 = FieldP2;
        this.DeckP1 = DeckP1;
        this.DeckP2 = DeckP2;
    }

    public int getTurn(){
        return this.turn;
    }
    
    public Player getCurrentPlayer(){
        if(this.turn==1){
            return this.P1;
        }
        else{
            return this.P2;
        }
    }

    // //ini phasenya belum di implement jd blm tau atribut & method & parameternya
    // public void nextPhase(Phase p){
    //     if (p.getPhase()==1){ //Draw Phase
    //         this.current = new Phase(2);
    //     }
    //     else if(p.getPhase()==2){ //Main Phase1
    //         this.current = new Phase(3);
    //     }
    //     else if(p.getPhase()==3){ //Battle Phase
    //         this.current = new Phase(4);
    //     }
    //     else if(p.getPhase()==4){ //Main Phase 2
    //         this.current = new Phase(5);
    //     }
    //     else{ //End Phase
    //         this.turn = this.turn%2 + 1;
    //         this.current = new Phase(1);
    //     }
    // }

    public void checkState(){
        if (this.P1.getHealth()==0 || this.P2.getHealth()==0){ //gameover
            this.run = false;
        }
        //kondisi tidak ada kartu pada lawan belumm!!!!!
    }

    public abstract void runPhase();

}