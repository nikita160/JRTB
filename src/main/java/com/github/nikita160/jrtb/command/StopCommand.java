package com.github.nikita160.jrtb.command;

import com.github.nikita160.jrtb.service.SendBotMessageService;
import com.github.nikita160.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    public static final String STOP_MESSAGE = "Good luck! \uD83D.";



    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().
                getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
