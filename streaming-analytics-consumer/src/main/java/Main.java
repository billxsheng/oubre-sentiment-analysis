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

//        SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
//        Dataset<Row> lines = spark
//                .readStream()
//                .format("kafka")
//                .option("kafka.bootstrap.servers", "localhost:9092")
//                .option("subscribe", "bill-test")
//                .load();
//        lines.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)");
//
//        List<String> list = lines.as(Encoders.STRING()).collectAsList();
//        Dataset<String> df1 = spark.createDataset(list, Encoders.STRING());
//
//
//        Dataset<Row> tweets = lines.map(df1);
//        query.awaitTermination();
    }
}
