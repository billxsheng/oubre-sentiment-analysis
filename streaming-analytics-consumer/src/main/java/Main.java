import org.apache.spark.sql.streaming.StreamingQueryException;
import spark.SparkKafkaConnect;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Logger.getLogger("org")
                .setLevel(Level.OFF);
        SparkKafkaConnect.connectToTopic();
    }
}
