package com.avatarduel.model;

public enum Element {
  WATER,
  FIRE,
  AIR,
  EARTH;
	
	public String toString() {
		String conv = "";
		if(this == WATER) conv = "Water";
		else if(this == FIRE) conv = "Fire";
		else if(this == AIR) conv = "Air";
		else if(this == EARTH) conv = "Earth";
		return conv;
	}
};
