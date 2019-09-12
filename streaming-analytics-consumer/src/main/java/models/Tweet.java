package models;

import java.io.Serializable;

public class Tweet implements Serializable {
    private String name;
    private String text;
    private String location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Tweet(String name, String text, String location) {
        this.name = name;
        this.text = text;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
