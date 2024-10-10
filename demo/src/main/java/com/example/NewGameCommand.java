package com.example;

public class NewGameCommand extends Command {

    NewGameCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    @Override
    public String execute() {
        game.setLength(3);
        game.generateMagicNumber();
        game.printNumber();
        String new_game_response = messageProvider.getMessage("NEW_GAME_RESPONSE");
        String response = String.format(new_game_response, game.getLength(), game.getLength());
        return response;
    }

}