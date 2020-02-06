package com.oubre.rollup.models;

import java.io.Serializable;


public class Tweet implements Serializable {
    public static final String TARGET_STRING = "";

    private String location;
    private String sentiment;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "location='" + location + '\'' +
                ", sentiment='" + sentiment + '\'' +
                '}';
    }
}
