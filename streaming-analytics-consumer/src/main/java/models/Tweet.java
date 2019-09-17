package models;

import com.google.gson.JsonObject;
import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;
import keys.keys;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.Serializable;


public class Tweet implements Serializable {
    public static final String TARGET_STRING = "";


    private String name;
    private String text;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String data;

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
    }

    @Override
    public String toString() {
        return "Tweet{" +
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
        String[] data = {tweet.getText()};
//        String res = ml.classifiers.classify(modelId, data).arrayResult.toJSONString();

        //json result doesnt work gotta come up with a different solution
        //not sure how to get the key of positive negative 
        JSONArray res = ml.classifiers.classify(modelId, data).arrayResult;
        JSONObject jo = new JSONObject();
        jo.put("res", res);
        JSONObject tweetObj = (JSONObject) new JSONParser().parse(jo);
        tweet.setData(jo.toString());
//        tweet.saveTweetToDB();
        return tweet.getData();
    }

//    public void saveTweetToDB() {
//
//    }
}
