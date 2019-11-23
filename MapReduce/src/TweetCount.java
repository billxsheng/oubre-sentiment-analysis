import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class TweetCount {
    //Map Cassandra DB rows into (location, 1)
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    }

    //Reduce to (location, sum(values))
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

    }

    public static void main(String[] args) {

    }
}