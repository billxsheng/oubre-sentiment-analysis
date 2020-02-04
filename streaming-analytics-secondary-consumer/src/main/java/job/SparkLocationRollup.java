package job;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import constants.Constants;
import models.Tweet;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SparkLocationRollup {
    SparkConf conf = new SparkConf().setAppName("spark-streaming").setMaster("local").set("spark.executor.memory", "1g");
    JavaSparkContext sc = new JavaSparkContext(conf);

    public void runJob() {
        Date now = new Date();
        Logger.getLogger("SparkLocationRollup").log(Level.INFO, "Starting Rollup Job from " + now.toString());
        JavaRDD<Tweet> cassandraRdd = CassandraJavaUtil.javaFunctions(sc)
                .cassandraTable(Constants.CASSANDRA_KEYSPACE_NAME, Constants.CASSANDRA_CORE_TWEETS_TABLE, CassandraJavaUtil.mapRowTo(Tweet.class))
                .select("location", "sentiment")
                .where("id < minTimeUUID(?)", now);

        cassandraRdd.foreach((Tweet tweet) -> {
            Logger.getLogger("SparkLocationRollup").log(Level.INFO, tweet.toString());
        });
    }

}
