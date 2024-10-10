package com.example;

public class CommandContext {

    private CommandType type;
    private Object param;

    CommandContext(CommandType type, Object param) {
        this.type = type;
        this.param = param;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public void setValues(Object param) {
        this.param = param;
    }

    public CommandType getType() {
        return type;
    }

    public Object getValue() {
        return param;
    }
}
