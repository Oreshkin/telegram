package com.epam.training.telegram.bot.game.uno.structure;

import com.epam.training.telegram.bot.game.uno.structure.deck.Card;

import java.util.ArrayList;
import java.util.Random;

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

    public void step() {
        Card currentCard = table.getCurrentCard();
        ArrayList<Card> suitable = new ArrayList<Card>();
        for (Card card : hand) {
            if (card.getColor().equals(currentCard.getColor()) || card.getValue().equals(currentCard.getValue()))
                suitable.add(card);
        }
        if (suitable.size() == 0) {
            Card card = table.getCard();
            if (card.getColor().equals(currentCard.getColor()) || card.getValue().equals(currentCard.getValue()))
                table.setCurrentCard(card);
            else hand.add(card);
        } else {
            int numberCardSelect = suitable.size() - 1;
            if (numberCardSelect > 0) numberCardSelect = new Random().nextInt(suitable.size() - 1);
            table.setCurrentCard(suitable.get(numberCardSelect));
            hand.remove(suitable.get(numberCardSelect));
        }
    }
}
