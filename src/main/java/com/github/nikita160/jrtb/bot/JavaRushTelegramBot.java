package com.github.nikita160.jrtb.bot;



import com.github.nikita160.jrtb.command.CommandContainer;
import com.github.nikita160.jrtb.command.CommandName;
import com.github.nikita160.jrtb.command.NoCommand;

import com.github.nikita160.jrtb.service.SendBotMessageService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public JavaRushTelegramBot(){
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));

    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }
            else commandContainer.retrieveCommand(CommandName.NO.getCommandName()).execute(update);

        }

    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
