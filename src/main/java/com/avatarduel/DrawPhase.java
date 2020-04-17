public class DrawPhase implements Phase{
    private int turn;
    private Decks player;
    private Power power;

    public DrawPhase(int turn, Decks player){
        this.turn = turn;
        this.player = player;
    }

    public void run(){
        int fire = this.player.countLand("FIRE");
        int water = this.player.countLand("WATER");
        int air = this.player.countLand("AIR");
        int earth = this.player.countLand("EARTH");
        this.power = new Power(fire,water,air,earth);
        this.deck.drawCard();
    }

}