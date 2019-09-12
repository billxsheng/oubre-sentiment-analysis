import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.streaming.api.java.JavaDStream;
import spark.SparkKafkaConnect;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) throws StreamingQueryException, InterruptedException {
        Logger.getLogger("org")
                .setLevel(Level.OFF);
        SparkKafkaConnect.connectToTopic();
    }
}
