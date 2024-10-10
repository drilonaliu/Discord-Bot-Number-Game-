package com.example;

public class GameController {

    private GameModel gameModel;
    private CommandInvoker commandInvoker;
    private MessageProvider messageProvider;
    private MessageParser messageParser;

    GameController() {
        this.messageProvider = new MessageProvider();
        this.messageProvider.setLanguage("en");
        this.gameModel = new GameModel();
        this.commandInvoker = new CommandInvoker();
        this.messageParser = new MessageParser();
        registerCommands();
    }

    private void registerCommands() {
        commandInvoker.registerCommand(CommandType.NEW_GAME, new NewGameCommand(gameModel, messageProvider));
        commandInvoker.registerCommand(CommandType.CHEAT, new CheatCommand(gameModel, messageProvider));
        commandInvoker.registerCommand(CommandType.GUESS, new GuessCommand(gameModel, messageProvider));
        commandInvoker.registerCommand(CommandType.LENGTH, new LengthCommand(gameModel, messageProvider));
        commandInvoker.registerCommand(CommandType.HELP, new HelpCommand(gameModel, messageProvider));
        commandInvoker.registerCommand(CommandType.LANGUAGE, new LanguageCommand(gameModel, messageProvider));
    }

    public String handleMessage(String message) {
        CommandContext commandContext = messageParser.parseMessage(message, messageProvider.getLanguage());
        String commandResponse = commandInvoker.executeCommand(commandContext);
        return commandResponse;
    }
}
