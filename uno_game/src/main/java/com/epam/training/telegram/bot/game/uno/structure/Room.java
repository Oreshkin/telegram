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
        int numberCardStart = 0;
        while (table.getDeck().getCards().get(numberCardStart).getValue().equals("P2")
                || table.getDeck().getCards().get(numberCardStart).getValue().equals("P4")
                || table.getDeck().getCards().get(numberCardStart).getValue().equals("CHANGE_COLOR")) {
            numberCardStart = new Random().nextInt(table.getDeck().getCards().size() - 1);
        }
        table.setCurrentCard(table.getDeck().getCards().get(numberCardStart));
        table.getDeck().getCards().remove(numberCardStart);
        if (table.getCurrentCard().getValue().equals("REVERT")) {
            bot.step();
        }
    }

    public boolean stepUser(String numberCard) {
        try {
            int i = Integer.parseInt(numberCard) - 1;
            if (i >= 0 && i <user.getHand().size()) {
                table.setCurrentCard(i, user.getHand());
                bot.step();
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR number");
        }
        return false;
    }
}
