package com.example;

public class LengthCommand extends VariableCommand {

    private int length;

    LengthCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void handleParameter(CommandContext commandContext) {
        length = (int) commandContext.getValue();
    }

    @Override
    public String execute() {
        game.setLength(length);
        game.generateMagicNumber();
        game.printNumber();
        String new_game_response = messageProvider.getMessage("NEW_GAME_RESPONSE");
        String response = String.format(new_game_response, game.getLength(), game.getLength());
        return response;
    }
}
