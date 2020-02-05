package models;

import com.datastax.driver.core.utils.UUIDs;
import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import keys.keys;
import org.json.simple.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


public class Tweet implements Serializable {
    public static final String[] SENTIMENTS = new String[]{"NEGATIVE", "NEUTRAL", "POSITIVE"};
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

    public static String processTweet(String text) {
        return text.replaceAll(TARGET_STRING, "");
    }

    public static String analyze(Tweet tweet) throws MonkeyLearnException {
        MonkeyLearn ml = new MonkeyLearn(keys.ML_API_KEY);
        String modelId = "cl_pi3C7JiL";
        String[] mlData = {tweet.getText()};

//        JSONArray res = ml.classifiers.classify(modelId, mlData).arrayResult;
//        JSONObject jo = new JSONObject();
//        jo.put("res", res);
//        String data = jo
//                .getJSONArray("res")
//                .getJSONArray(0)
//                .getJSONArray(0)
//                .getJSONObject(0)
//                .get("label")
//                .toString();

        tweet.setSentiment(SENTIMENTS[ThreadLocalRandom.current().nextInt(0, 2)]);
        tweet.setId(UUIDs.timeBased());
        return tweet.toString();
    }
}
