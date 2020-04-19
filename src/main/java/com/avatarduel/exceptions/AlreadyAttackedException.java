package com.avatarduel.exceptions;

public class AlreadyAttackedException  extends Exception {

    String message;

    public AlreadyAttackedException() {
        this.message = "Kartu ini sudah digunakan untuk menyerang, tidak dapat menyerng dua kali.";
    }
    
    @Override
    public String toString() {
        return this.message;
    }
}