package com.oubre.rollup.spark;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.oubre.rollup.cassandra.CassandraRepository;
import com.oubre.rollup.models.Tweet;
import com.oubre.rollup.constants.Constants;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SparkLocationRollup {
    SparkConf conf = new SparkConf().setAppName("spark-streaming").setMaster("local").set("spark.executor.memory", "1g");
    JavaSparkContext sc = new JavaSparkContext(conf);

    public void runJob(CassandraRepository cr) {
        Date now = new Date();
        Logger.getLogger("SparkLocationRollup").log(Level.INFO, "Starting Rollup Job from " + now.toString());
        JavaPairRDD<String, Integer> cassandraRdd = CassandraJavaUtil.javaFunctions(sc)
                .cassandraTable(Constants.CASSANDRA_KEYSPACE_NAME, Constants.CASSANDRA_CORE_TWEETS_TABLE, CassandraJavaUtil.mapRowTo(Tweet.class))
                .select("location", "sentiment")
                .where("id < minTimeUUID(?)", now) // and greater than previous day
                .mapToPair((tweet) -> new Tuple2<>(tweet.getLocation() + " " + tweet.getSentiment(), 1))
                .reduceByKey((accumulator, n) -> (accumulator + n));
//                .mapToPair((location) -> {
//                    Row row = cr.getPrevRow(location._1);
//                    if(row == null) {
//                        return location;
//                    } else {
//                        return new Tuple2<>(location._1, location._2 + row.getInt("count"));
//                    }
//                });

        CassandraJavaUtil.javaFunctions(cassandraRdd).writerBuilder(Constants.CASSANDRA_KEYSPACE_NAME, Constants.CASSANDRA_CORE_LOCATION_TABLE, CassandraJavaUtil.mapTupleToRow(String.class, Integer.class)).saveToCassandra();
    }
}
