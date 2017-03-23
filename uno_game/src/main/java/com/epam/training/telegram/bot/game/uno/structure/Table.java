package com.epam.training.telegram.bot.game.uno.structure;

import com.epam.training.telegram.bot.game.uno.structure.deck.Card;
import com.epam.training.telegram.bot.game.uno.structure.deck.Deck;

import java.util.ArrayList;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Table {

    private Deck deck;
    private Card currentCard = null;

    public Deck getDeck() {
        return deck;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Table() {
        this.deck = new Deck();
    }
}
