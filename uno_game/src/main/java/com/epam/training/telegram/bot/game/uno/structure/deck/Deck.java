package com.epam.training.telegram.bot.game.uno.structure.deck;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Deck {

    private ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        Collections.shuffle(cards);
        this.cards = cards;
    }

    public Deck() {
        cards = new ArrayList<Card>();
        createDeck();
        Collections.shuffle(cards);
    }

    enum Function {
        REVERT, SKIP, P2
    }

    enum Color {
        RED, YELLOW, GREEN, BLUE
    }

    enum BlackCard {
        CHANGE_COLOR, P4
    }

    private void createDeck() {
        for (Color color : Color.values()) {
            for (int i = 0; i < 2; i++)
                for (Function function : Function.values()) cards.add(new Card(color.toString(), function.toString()));
            boolean flag = true;
            for (int i = 0; i <= 9; i++) {
                cards.add(new Card(color.toString(), i));
                if (i + 1 == 10 && flag) {
                    flag = false;
                    i = 0;
                }
            }
        }
        for (BlackCard blackCard : BlackCard.values())
            for (int i = 0; i < 4; i++)
                cards.add(new Card(blackCard.toString(), blackCard.toString()));
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
