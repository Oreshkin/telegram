package com.epam.training.telegram.bot.game.uno.structure.deck;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Card {

    private String color;
    private String value;

    public Card(String color, int value) {
        this.color = color;
        this.value = String.valueOf(value);
    }

    public Card(String value) {
        this.color = value;
        this.value = value;
    }

    @Override
    public String toString() {
        return "\nCard{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
