//package com.avatarduel.phase;
//
//import com.avatarduel.state.*;
//import com.avatarduel.cards.*;
//
//public class MainPhase1 implements Phase{
//    private int turn;
//    private Decks player;
//    private Power power;
//    private boolean cek_putland;
//
//    public MainPhase1(int turn, Decks player, Power power){
//        this.turn = turn;
//        this.player = player;
//        this.power = power;
//        this.cek_putland = true;
//    }
//
//    public void putCardToField(Card c, int position){
//        if (c.type()=="land"){
//            if (this.cek_putland){
//                this.player.addToField(c, position);
//                this.cek_putland = false;
//            }
//            else{
//                System.out.println("Failed to put land card in field");
//            }
//        }
//        else if (c.type()=="skill"){
//
//        }
//        else{
//            if (this.power.getPower(c.getType()) - c.getPower() >=0){
//                this.player.addToField(c, position);
//                this.power.setPower(c.getType(), this.power.getPower(c.getType())-c.getPower());
//            }
//            else{
//                System.out.println("Don't have enough power");
//            }
//        }
//    }
//
//    public void throwSkill(Card c){
//        if(c.getType()=="skill"){
//            this.player.removeFromField(c);
//        }
//        else{
//            System.out.println("This is not a skill card");
//        }
//    }
//
//    public void run(){
//        boolean running = true;
//        int aksi;
//        while(true){
//            Card c;
//            if (aksi == 1){
//                putCardToField(c, 0);
//
//            }
//            else if(aksi==2){
//                moveCard(c,0);
//            }
//            else{
//                throwSkill(c,0);
//            }
//        }
//    }
//
//}
