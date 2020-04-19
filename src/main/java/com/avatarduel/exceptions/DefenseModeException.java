package com.avatarduel.exceptions;

public class DefenseModeException extends Exception {

    String message;

    public DefenseModeException() {
        this.message = "Tidak bisa menyerang jika posisi kartu kamu dalam kondisi bertahan.";
    }
    
    @Override
    public String toString() {
        return this.message;
    }
}