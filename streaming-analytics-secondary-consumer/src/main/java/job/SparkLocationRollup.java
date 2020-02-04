package job;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import constants.Constants;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;

public class SparkLocationRollup {
    SparkConf conf = new SparkConf();
    SparkContext sc = new SparkContext(conf);
    JavaRDD cassandraRdd = CassandraJavaUtil.javaFunctions(sc)
            .cassandraTable(Constants.CASSANDRA_KEYSPACE_NAME, Constants.CASSANDRA_CORE_TWEETS_TABLE);

}
