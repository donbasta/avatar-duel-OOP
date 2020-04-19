package com.avatarduel.exceptions;

public class StrongerEnemyCardException extends Exception {
    String message;

    public StrongerEnemyCardException() {
        this.message = "Tidak bisa menyerang kartu musuh yang lebih kuat atau sama.";
    }

    public String toString() {
        return this.message;
    }
}