package com.avatarduel.state;

import com.avatarduel.model.Element;

public class Power{
    private int fire;
    private int water;
    private int air;
    private int earth;
    
    public Power() {
    	this.fire = this.water = this.air = this.earth = 0;
    }

    public Power(int fire, int water, int air, int earth){
        this.fire = fire;
        this.water = water;
        this.air = air;
        this.earth = earth;
    }

    public int getPower(Element element){
        if (element == Element.FIRE){
            return this.fire;
        }
        else if (element == Element.WATER){
            return this.water;
        }
        else if (element == Element.AIR){
            return this.air;
        }
        else if(element == Element.EARTH){
            return this.earth;
        }
        else{
            System.out.println("errorrr input");
            return 0;
        }
    }

    public void setPower(Element element, int x){
        if (element == Element.FIRE){
            this.fire = x;
        }
        else if (element == Element.WATER){
            this.water = x;
        }
        else if (element == Element.AIR){
            this.air = x;
        }
        else if(element == Element.EARTH){
            this.earth = x;
        }
        else{
            System.out.println("errorrr input");
        }
    }
}
