package com.example;

import java.util.ResourceBundle;

public class MessageParser {

    public CommandContext parseMessage(String userInput, String languageCode) {

        CommandContext commandContext;
        ResourceBundle commandsProps = ResourceBundle.getBundle("commands_en");

        if (isMessageAGuess(userInput)) {
            commandContext = parseGuess(userInput);
        } else if (userInput.startsWith(commandsProps.getString("LENGTH"))) {
            commandContext = parseLength(userInput);
        } else if (userInput.startsWith(commandsProps.getString("LANGUAGE"))) {
            commandContext = parseLanguage(userInput);
        } else {
            commandContext = parseInputToCommand(userInput, commandsProps);
        }
        return commandContext;
    }

    private CommandContext parseLanguage(String userInput) {
        CommandType commandType = CommandType.LANGUAGE;
        String value = userInput.substring(9);
        return new CommandContext(commandType, value);
    }

    private CommandContext parseGuess(String userInput) {
        CommandType commandType = CommandType.GUESS;
        int value = (int) Integer.parseInt(userInput);
        return new CommandContext(commandType, value);
    }

    private CommandContext parseLength(String userInput) {
        CommandType commandType = CommandType.LENGTH;
        String num = userInput.charAt(6) + "";
        int value = (int) Integer.parseInt(num);
        return new CommandContext(commandType, value);
    }

    private CommandContext parseInputToCommand(String userInput, ResourceBundle commandsProps) {
        CommandType commandType = null;
        for (CommandType command : CommandType.values()) {
            if (userInput.equalsIgnoreCase(commandsProps.getString(command.name()))) {
                commandType = command;
            }
        }

        CommandContext commandContext = new CommandContext(commandType, null);
        return commandContext;
    }

    private boolean isMessageAGuess(String string) {
        return (string.matches("[0-9]+") && string.length() > 0);
    }

}
