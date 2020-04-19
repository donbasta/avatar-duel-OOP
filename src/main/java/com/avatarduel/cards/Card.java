package com.avatarduel.cards;

import com.avatarduel.model.Element;

public abstract class Card {
    protected String name;
    protected String desc;
    protected Element element;
    protected String path;
    
    public Card(String name, String desc, Element element, String path){
        this.name = name;
        this.desc = desc;
        this.element = element;
        this.path = path;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.desc;
    }

    public Element getElement(){
        return this.element;
    }

    public String getPath(){
        return this.path;
    }

}