package com.github.nikita160.jrtb.command;

import com.github.nikita160.jrtb.repository.entity.TelegramUser;
import com.github.nikita160.jrtb.service.SendBotMessageService;
import com.github.nikita160.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "hi! I''m nikita160 bot, here we go";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {

        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
