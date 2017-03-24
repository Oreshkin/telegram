package com.epam.training.telegram.bot.game.uno;

import com.epam.training.telegram.bot.game.uno.structure.Room;
import com.epam.training.telegram.bot.game.uno.structure.User;
import com.epam.training.telegram.bot.game.uno.structure.deck.Deck;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aliaksandr_Aryshka on 23-Mar-17.
 */
public class Main {

    public static void main (String args[]) throws IOException {

        User user = new User("372807820", "Aliaksandr");
        Room room = new Room("372807820", user);

        printInfo(room, user);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.next();
            room.stepUser(next);
            printInfo(room, user);
        }
    }

    private static void printInfo(Room room, User user){
        System.out.println("=======================================");
        System.out.println("ID Room: " + room.getChatID());
        System.out.println("Count card in deck: " + room.getTable().getDeck().getCards().size());
        System.out.println("Table currentcard: " + room.getTable().getCurrentCard());
        System.out.println("Table direction: " + room.getTable().direction());
        System.out.println("Table end cards: " + room.getTable().getEndCards());
        System.out.println("=======================================");
        System.out.println("Count card in User: " + room.getUser().getHand().size());
        System.out.println("Cards User: " + room.getUser().getHand());
        System.out.println("=======================================");
        System.out.println("Count card in Bot: " + room.getBot().getHand().size());
        System.out.println("Cards Bot: " + room.getBot().getHand());
        System.out.println("=======================================");
    }
}
