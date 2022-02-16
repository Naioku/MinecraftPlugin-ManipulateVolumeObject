package pl.adrian_komuda.manipulate_volume_object.commands.console_and_players.particular_commands;

import org.bukkit.command.CommandSender;
import pl.adrian_komuda.manipulate_volume_object.TestFlags;
import pl.adrian_komuda.manipulate_volume_object.commands.CommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith0Params;

import java.util.List;

public class DisableFunctionalTests implements CommandsPerformers {
    @Override
    public void perform(CommandSender commandSender, String command, List<String> args) {
        TestFlags.FUNCTIONAL_TEST_FLAG = false;
        commandSender.sendMessage(String.valueOf(MessagesWith0Params.FUNCTIONAL_TESTS_DISABLED.getMessage()));
    }
}
