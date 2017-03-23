package com.epam.training.telegram.bot.game.uno.structure;

import java.util.Random;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Room {

    private String chatID;
    private Table table;
    private User user;
    private Bot bot;
    private boolean direction;

    public String getChatID() {
        return chatID;
    }

    public Table getTable() {
        return table;
    }

    public User getUser() {
        return user;
    }

    public Bot getBot() {
        return bot;
    }

    public Room(String chatID, User user) {
        this.chatID = chatID;
        this.table = new Table();
        this.user = user;
        this.bot = new Bot(table);
        setupRoom();
    }

    private void setupRoom() {
        for (int i=0; i<7; i++) {
            int numberCardUser = 0;
            int numberCardBot = 0;
            while (numberCardUser == numberCardBot) {
                numberCardUser = new Random().nextInt(table.getDeck().getCards().size() - 1);
                numberCardBot = new Random().nextInt(table.getDeck().getCards().size() - 1);
            }
            user.getHand().add(table.getDeck().getCards().get(numberCardUser));
            bot.getHand().add(table.getDeck().getCards().get(numberCardBot));
            table.getDeck().getCards().remove(numberCardUser);
            table.getDeck().getCards().remove(numberCardBot);
        }
    }

    public boolean stepUser() {
        return false;
    }
}
