package com.example;

//Discord
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public class BotInteraction extends ListenerAdapter {

    private Map<String, GameController> gameStates = new HashMap<>();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        // Bot does not dispatch their own messages
        if (!event.getAuthor().isBot()) {
            // Discord user enters a message
            MessageChannel channel = event.getChannel();
            // Create a response
            String response = createResponse(event);
            // Send the response back to the channel
            channel.sendMessage(response).queue();
        }
    }

    private String createResponse(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        String guildId = event.getGuild().getId();
        gameStates.putIfAbsent(guildId, new GameController());
        GameController gameController = gameStates.get(guildId);
        String response = gameController.handleMessage(msg);
        return response;
    }

}
