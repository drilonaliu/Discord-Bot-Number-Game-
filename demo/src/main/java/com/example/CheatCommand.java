package com.example;

public class CheatCommand extends Command {

    CheatCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    @Override
    public String execute() {
        String cheat = messageProvider.getMessage("CHEAT");
        String response = String.format(cheat, Integer.valueOf(game.getMagicNumber()));
        return response;
    }

}
