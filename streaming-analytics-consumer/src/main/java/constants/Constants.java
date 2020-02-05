package constants;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
    public static final String CASSANDRA_KEYSPACE_NAME = "oubre";
    public static final String CASSANDRA_CORE_TWEETS_TABLE = "tweets";
    public static final ArrayList<String> SENTIMENT_LOCATIONS = new ArrayList<>(Arrays.asList("Toronto", "New York", "Los Angeles"));
}
