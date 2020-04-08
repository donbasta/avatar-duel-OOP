package com.avatarduel.gui;

public class CardViewer {
	
	private boolean isUp;
	private boolean isAda;
	private String imagepath;
	
	public CardViewer() {
		this.isUp = false;
		this.isAda = false;
		this.imagepath = "";
	}
	
	public CardViewer(boolean isUp, boolean isAda, String imagepath){
		this.isUp = isUp;
		this.isAda = isAda;
		this.imagepath = imagepath;
	}
	
	public void setUp(boolean b) {
		this.isUp = b;
	}
	
	public void setAda(boolean b) {
		this.isAda = b;
	}
	
	public void setImagePath(String path) {
		this.imagepath = path;
	}
	
	public boolean getUp() {
		return this.isUp;
	}
	
	public boolean getAda() {
		return this.isAda;
	}
	
	public String getPath() {
		return this.imagepath;
	}

}
