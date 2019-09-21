package models;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import keys.keys;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.SparkSession;
import org.json.simple.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public class Tweet implements Serializable {
    public static final String TARGET_STRING = "";

    private UUID id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private String name;
    private String text;
    private String location;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Tweet(String name, String text, String location) {
        this.name = name;
        this.text = text;
        this.location = location;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", location='" + location + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public static String processTweet(String text) {
        return text.replaceAll(TARGET_STRING, "");
    }

    public static String analyze(Tweet tweet) throws MonkeyLearnException {
        MonkeyLearn ml = new MonkeyLearn(keys.ML_API_KEY);
        String modelId = "cl_pi3C7JiL";
        String[] mlData = {tweet.getText()};

        JSONArray res = ml.classifiers.classify(modelId, mlData).arrayResult;
        JSONObject jo = new JSONObject();
        jo.put("res", res);
        String data = jo
                .getJSONArray("res")
                .getJSONArray(0)
                .getJSONArray(0)
                .getJSONObject(0)
                .get("label")
                .toString();

        tweet.setData(data);

        return tweet.toString();
    }
}
