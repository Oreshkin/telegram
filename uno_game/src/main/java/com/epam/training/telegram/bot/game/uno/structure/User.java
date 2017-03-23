package com.epam.training.telegram.bot.game.uno.structure;

import com.epam.training.telegram.bot.game.uno.structure.deck.Card;

import java.util.ArrayList;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class User {

    private String id;
    private String firstName;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public User(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
