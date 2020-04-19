package com.avatarduel.state;

import com.avatarduel.model.Element;

/**
 * Power describes the current
 * power of all the element a 
 * player has.
 *
 * @author 
 */
public class Power{
    private int fire;
    private int water;
    private int air;
    private int earth;
    private int energy;
    private int maxFire;
    private int maxWater;
    private int maxAir;
    private int maxEarth;
    private int maxEnergy;

    public Power() {
    	this.fire = this.water = this.air = this.earth = 0 = this.energy = 0;
    	this.maxFire = this.maxWater = this.maxAir = this.maxEarth = 0 = this.maxEnergy = 0;
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
        else if(element == Element.ENERGY){
            return this.energy;
        } else{
            System.out.println("errorrr input");
            return 0;
        }
    }

    public void addPower(Element element){
        if (element == Element.FIRE){
            this.fire++;
            this.maxFire++;
        }
        else if (element == Element.WATER){
            this.water++;
            this.maxWater++;
        }
        else if (element == Element.AIR){
            this.air++;
            this.maxAir++;
        }
        else if(element == Element.EARTH){
            this.earth++;
            this.maxEarth++;
        }
        else if(element == Element.ENERGY){
            this.energy;
            this.maxEnergy++;
        } else{
            System.out.println("errorrr input");
        }
    }
    
    public void usePower(Element element, int amount) {
		  if (element == Element.FIRE){
	          this.fire -= amount;
	      }
	      else if (element == Element.WATER){
	          this.water -= amount;
	      }
	      else if (element == Element.AIR){
	          this.air -= amount;
	      }
	      else if(element == Element.EARTH){
	          this.earth -= amount;
	      }
          else if(element == Element.ENERGY){
	          this.energy -= amount;
	      } else{
	          System.out.println("errorrr input");
	      }
    }
    
    public void fullPower(){
        this.fire = this.maxFire;
        this.water = this.maxWater;
        this.air = this.maxAir;
        this.earth = this.maxEarth;
        this.energy = this.maxEnergy;
    }
    
    public int getFire() {
    	return this.fire;
    }
    
    public int getMaxFire() {
    	return this.maxFire;
    }
    
    public int getWater() {
    	return this.water;
    }
    
    public int getMaxWater() {
    	return this.maxWater;
    }
    
    public int getEarth() {
    	return this.earth;
    }
    
    public int getMaxEarth() {
    	return this.maxEarth;
    }
    
    public int getAir() {
    	return this.air;
    }
    
    public int getMaxAir() {
    	return this.maxAir;
    }

    public int getEnergy(){
        return this.energy;
    }

    public int getMaxEnergy(){
        return this.maxEnergy;
    }
    
}
