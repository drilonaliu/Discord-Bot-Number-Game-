package com.example;

public class GuessCommand extends VariableCommand {

    private Guess userGuess;

    public GuessCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    @Override
    public void handleParameter(CommandContext commandContext) {
        int guess = (int) commandContext.getValue();
        userGuess = new Guess(guess, game.getLength());
    }

    @Override
    public String execute() {
        String response = "";
        if (!userGuess.hasCorrectLength()) {
            String bad_length = messageProvider.getMessage("BAD_LENGTH");
            response = String.format(bad_length, game.getLength());
        } else if (userGuess.hasRepeatedDigits()) {
            response = messageProvider.getMessage("REPETITION");
        } else {
            int[] result = game.evaluateGuess(userGuess);
            String guess_results = messageProvider.getMessage("GUESS_RESULTS");
            response = String.format(guess_results, result[0], result[1]);
            if (result[1] == game.getLength()) {
                response = messageProvider.getMessage("WIN");
                game.generateMagicNumber();

            }
        }
        return response;
    }

    public void setUserGuess(Guess userGuess) {
        this.userGuess = userGuess;
    }

}
