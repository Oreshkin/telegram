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

    public Deck() {
        cards = new ArrayList<Card>();
        createDeck();
        Collections.shuffle(cards);
    }

    enum TwoPack {
        RED_REVERT, YELLOW_REVERT, GREEN_REVERT, BLUE_REVERT,
        RED_SKIP, YELLOW_SKIP, GREEN_SKIP, BLUE_SKIP,
        RED_P2, YELLOW_P2, GREEN_P2, BLUE_P2
    }

    enum FourPack {
        CHANGE_COLOR, P4
    }

    enum RemainingCards {
        RED, YELLOW, GREEN, BLUE
    }

    private void createDeck() {
        for (TwoPack twoPack : TwoPack.values()) createCards(2, twoPack);
        for (FourPack fourPack : FourPack.values()) createCards(4, fourPack);
        for (RemainingCards cards : RemainingCards.values()) {
            createCards(0, 9, cards);
            createCards(1, 9, cards);
        }
    }

    private void createCards(int count, TwoPack color) {
        for (int i=0; i<count; i++) cards.add(new Card(color.toString()));
    }

    private void createCards(int count, FourPack color) {
        for (int i=0; i<count; i++) cards.add(new Card(color.toString()));
    }

    private void createCards(int start, int end, RemainingCards color) {
        for (int i=start; i<=end; i++) cards.add(new Card(color.toString(), i));
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
