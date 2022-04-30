package command;

import com.github.nikita160.jrtb.command.Command;
import com.github.nikita160.jrtb.command.StatCommand;

import static com.github.nikita160.jrtb.command.CommandName.STAT;
import static com.github.nikita160.jrtb.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
