package com.example;

import java.util.ResourceBundle;

public class MessageProvider {

    private String language;

    public String getMessage(String key) {
        ResourceBundle commandsProps = ResourceBundle.getBundle(language);
        String response = commandsProps.getString(key);
        return response;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
