package com.epam.training.telegram.bot.oreshkin.updateshandlers;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.logging.BotLogger;

import static com.epam.training.telegram.bot.oreshkin.BotConfig.CHANNEL_TOKEN;
import static com.epam.training.telegram.bot.oreshkin.BotConfig.CHANNEL_USER;

/**
 * Created by Aliaksandr_Aryshka on 22-Mar-17.
 */
public class BotHandlers extends TelegramLongPollingBot {

    private static final String LOGTAG = "ORESHKIN_BOT";


    private static final String HELP_TEXT = "Send me the channel username where you added me as admin.";


    public BotHandlers() {
        super();
    }

    @Override
    public String getBotUsername() {
        return CHANNEL_USER;
    }

    @Override
    public String getBotToken() {
        return CHANNEL_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText() || message.hasLocation()) {
                    System.out.println(message.toString());
                }
            }
        } catch (Exception e) {
            BotLogger.error(LOGTAG, e);
        }
    }


}
