import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;
import spark.SparkKafkaConnect;
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
//        val rdd = rddRaw.map(_.value.toString);
//        val df = spark.read.json(rdd);
//
//
//        query.awaitTermination();
    }
}
