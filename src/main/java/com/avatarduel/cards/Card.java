package com.avatarduel.cards;

import com.avatarduel.model.Element;

public abstract class Card {
    private String name;
    private String desc;
    private Element element;

    public Card(String name, String desc, Element element){
        this.name = name;
        this.desc = desc;
        this.element = element;
    }

}