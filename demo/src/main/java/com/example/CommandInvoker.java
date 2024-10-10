package com.example;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private Map<CommandType, Command> commands = new HashMap<>();

    public void registerCommand(CommandType commandName, Command command) {
        commands.put(commandName, command);
    }

    public String executeCommand(CommandType commandName) {
        Command command = commands.get(commandName);
        return command.execute();
    }

    public String executeCommand(CommandContext commandContext) {
        Command command = commands.get(commandContext.getType());
        if (VariableCommand.class.isAssignableFrom(command.getClass())) {
            VariableCommand variableCommand = (VariableCommand) command;
            variableCommand.handleParameter(commandContext);
        }
        return command.execute();
    }

    public Command getCommandByName(CommandType commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
