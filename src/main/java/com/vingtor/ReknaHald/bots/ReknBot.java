package com.vingtor.ReknaHald.bots;

import com.vingtor.ReknaHald.processor.telegramRequestProcessor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class ReknBot extends TelegramLongPollingBot {

    private String token = "8218651761:AAELz3Fr-UnblF7sxUwxqhhdU3xxMBvBHro";

    private String username = "FinancesControllBot";

    @PostConstruct
    public void init() {
        initCommands();
    }

    @Override public String getBotUsername() { return username; }
    @Override public String getBotToken() { return token; }


    private void initCommands() {
        try {
            execute(new SetMyCommands(List.of(
                    new BotCommand("ola","Mostra o texto de início do bot"),
                    new BotCommand("ajuda","Mostra a mensagem de ajuda")
            ), null, null));
        } catch (TelegramApiException e) { e.printStackTrace(); }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!(update.hasMessage() && update.getMessage().hasText())) return;

        String message = update.getMessage().getText();
        String[] request = message.split(" ");
        long chatId = update.getMessage().getChatId();

        telegramRequestProcessor processor = new telegramRequestProcessor();

        String reply;

        try {
            reply = processor.processRequest(request);
        } catch (Exception e) {
            reply = e.getMessage();
            e.printStackTrace();
        }

        try {
            execute(SendMessage.builder().chatId(Long.toString(chatId)).text(reply).build());
        } catch (TelegramApiException e) { e.printStackTrace(); }
    }
}
