package com.example;

public abstract class VariableCommand extends Command {

    VariableCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    public abstract void handleParameter(CommandContext commandContext);

}