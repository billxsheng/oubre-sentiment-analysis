package models;

import com.datastax.driver.core.utils.UUIDs;
import java.io.Serializable;
import java.util.UUID;


public class Tweet implements Serializable {
    public static final String TARGET_STRING = "";

    private UUID id;
    private String name;
    private String text;
    private String location;
    private String sentiment;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public Tweet(String name, String text, String location) {
        this.name = name;
        this.text = text;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", location='" + location + '\'' +
                ", sentiment='" + sentiment + '\'' +
                '}';
    }
}
