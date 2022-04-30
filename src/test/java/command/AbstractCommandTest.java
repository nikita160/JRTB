package command;

import com.github.nikita160.jrtb.bot.JavaRushTelegramBot;
import com.github.nikita160.jrtb.command.Command;
import com.github.nikita160.jrtb.repository.TelegramUserRepository;
import com.github.nikita160.jrtb.service.SendBotMessageService;
import com.github.nikita160.jrtb.service.SendBotMessageServiceImpl;
import com.github.nikita160.jrtb.service.TelegramUserService;
import com.github.nikita160.jrtb.service.TelegramUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract public class AbstractCommandTest {
    protected JavaRushTelegramBot bot = Mockito.mock(JavaRushTelegramBot.class);
    protected TelegramUserRepository repository= Mockito.mock(TelegramUserRepository.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(bot);
    protected TelegramUserService telegramUserService = new TelegramUserServiceImpl(repository);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(bot).execute(sendMessage);
    }
}
