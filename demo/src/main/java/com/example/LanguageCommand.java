package com.example;

public class LanguageCommand extends VariableCommand {

    private String languageCode;

    LanguageCommand(GameModel game, MessageProvider messageProvider) {
        super(game, messageProvider);
    }

    @Override
    public void handleParameter(CommandContext commandContext) {
        languageCode = (String) commandContext.getValue();
    }

    @Override
    public String execute() {
        messageProvider.setLanguage(languageCode);
        String response = messageProvider.getMessage("LANGUAGE");
        return response;
    }

}
