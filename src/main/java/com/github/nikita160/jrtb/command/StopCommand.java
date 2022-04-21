package com.github.nikita160.jrtb.command;

import com.github.nikita160.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    public static final String STOP_MESSAGE = "Good luck! \uD83D.";



    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().
                getChatId().toString(), STOP_MESSAGE);
    }
}
