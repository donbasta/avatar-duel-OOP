package com.avatarduel.exceptions;

public class StrongerEnemyCardException extends Throwable {
    String message;

    public StrongerEnemyCardException() {
        this.message = "Tidak bisa menyerang kartu musuh yang lebih kuat atau sama.";
    }

    public String toString() {
        return this.message;
    }
}
