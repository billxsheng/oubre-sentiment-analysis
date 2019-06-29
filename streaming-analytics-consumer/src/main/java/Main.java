import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException, StreamingQueryException {
        SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
        Dataset<Row> dataStream = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "bill-test")
                .load();

//        dataStream.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)");

        Dataset<String> data = dataStream
                .as(Encoders.STRING())
                .flatMap((FlatMapFunction<String, String>) x -> Arrays.asList(x.split(" ")).iterator(), Encoders.STRING());

        StreamingQuery query = data.writeStream()
                .outputMode("complete")
                .format("console")
                .start();

        query.awaitTermination();
    }
}
