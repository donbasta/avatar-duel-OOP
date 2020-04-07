import java.util.*;

public class Player{
    private int health;
    private List hand;
    
    public Player(int health, List hand){
        this.health = health;
        this.hand = hand;
    }

    public int getHealth(){
        return this.health;
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