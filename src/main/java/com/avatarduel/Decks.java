public class Decks{
    private List hand;
    private List field;
    private Stack deck;
    

    public Decks(){
        this.hand = new ArrayList<Card>();
        this.field = new ArrayList<SummonedCard>();
        this.deck = new Stack<Card>();
    }

    public List getHand(){
        return this.getHand();
    }

    public List getField(){
        return this.getField();
    }

    public List getDeck(){
        return this.getDeck();
    }


    public void drawCard(){
        Card c;
        c = this.deck.pop();
        this.hand.add(c);
    }
    public void addToDeck(Card c){
        this.deck.add(c);
    }
    // public void addToHand(){
        
    // }

    public void addToField(Card c, int position){
        this.hand.remove(this.hand.get(c));
        SummonedCard sc = new SummonedCard(c,position);
        if(/*jika position blm ada*/)
        {this.field.add(sc);}
        else{
            System.out.println("Position are taken");
        }
        
    }

    public void removeFromField(Card c){
        if (/*c ada di field*/){
        this.field.remove(this.field.get(c));
        }
        else{
            System.out.println("Card is not in the field");
        }
    }

    public int countLand(String elemen){
        int count = 0;
        for (int i=0;i<hand.size();i++){
            if (hand.get(0)==elemen){
                count++;
            }
        }
        return count;
    }

}