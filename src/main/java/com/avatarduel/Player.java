import java.util.*;

public class Player{
    private int health;
    // private List hand;
    private Decks cards;
    private Power power;
    
    public Player(int health, Decks cards,Power power){
        this.health = health;
        this.cards = cards;
        this.power = power;
    }

    public int getHealth(){
        return this.health;
    }

    public int getPower(){
        return this.power;
    }

    public Decks getCards(){
        return this.cards;
    }
    
    public void setHealth(int health){
        if(health<0){
            this.health = 0;
        }
        else{
            this.health = health;
        }
    }
}