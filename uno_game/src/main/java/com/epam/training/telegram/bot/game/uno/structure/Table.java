package com.epam.training.telegram.bot.game.uno.structure;

import com.epam.training.telegram.bot.game.uno.structure.deck.Card;
import com.epam.training.telegram.bot.game.uno.structure.deck.Deck;

import java.util.ArrayList;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Table {

    private Deck deck;
    private ArrayList<Card> endCards = new ArrayList<Card>();
    private Card currentCard = null;
    private boolean direction = true;

    public Deck getDeck() {
        return deck;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public ArrayList<Card> getEndCards() {
        return endCards;
    }

    public boolean direction() {
        return direction;
    }

    public void setCurrentCard(Card currentCard) {
        endCards.add(currentCard);
        this.currentCard = currentCard;
    }

    public Table() {
        this.deck = new Deck();
    }

    public Card getCard() {
        if (deck.getCards().size() == 0) {
            deck.setCards(endCards);
            endCards.clear();
        }
        Card card = deck.getCards().get(0);
        deck.getCards().remove(card);
        return card;
    }

    public boolean setCurrentCard(int i, ArrayList<Card> hand) {
        Card card = hand.get(i);
        if (card.getColor().equals(currentCard.getColor())) {
            currentCard = card;
            hand.remove(card);
            return true;
        } else if (card.getValue().equals(currentCard.getValue())) {
            currentCard = card;
            hand.remove(card);
            return true;
        } else {
            return false;
        }
    }



}
