package com.example;

public abstract class Command {

    protected GameModel game;
    protected MessageProvider messageProvider;

    Command(GameModel game, MessageProvider messageProvider) {
        this.game = game;
        this.messageProvider = messageProvider;
    }

    public abstract String execute();

}
