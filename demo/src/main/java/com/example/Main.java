package com.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

    public static void main(String[] args) {
        // Build the bot
        String token = "";// PUT YOUR TOKEN HERE
        try {
            JDABuilder builder = JDABuilder
                    .createDefault(token);
            builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
            // Create the GameBot
            BotInteraction botEventListener = new BotInteraction();
            // Inject the botEventListener to the game controller
            builder.addEventListeners(botEventListener);
            builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}