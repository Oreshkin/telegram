package com.epam.training.telegram.bot.game.uno.structure;

import com.epam.training.telegram.bot.game.uno.structure.deck.Card;

import java.util.ArrayList;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Bot {

    private Table table;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Bot(Table table) {
        this.table = table;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
