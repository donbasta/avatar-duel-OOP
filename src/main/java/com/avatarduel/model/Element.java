package com.avatarduel.model;

/**
 * Element describes the element
 * available at the game
 *
 * @author 
 */
public enum Element {
  WATER,
  FIRE,
  AIR,
  EARTH,
  ENERGY;
	
	public String toString() {
		String conv = "";
		if(this == WATER) conv = "Water";
		else if(this == FIRE) conv = "Fire";
		else if(this == AIR) conv = "Air";
		else if(this == EARTH) conv = "Earth";
		else if(this == ENERGY) conv = "Energy";
		return conv;
	}
};
