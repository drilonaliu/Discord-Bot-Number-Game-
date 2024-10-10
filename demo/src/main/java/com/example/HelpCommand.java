package com.example;

public class HelpCommand extends Command {

    HelpCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    @Override
    public String execute() {
        String all_commands_response = messageProvider.getMessage("ALL_COMMANDS");
        return all_commands_response;
    }

}
