import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class TweetCount {
    //Map Cassandra DB rows into (location, 1)
    //Angle brackets include input/output
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
        //Hadoop Integer, optimized to provide serialization in Hadoop
        //Serialization is the process of converting an object into a stream of bytes to store
        private final static IntWritable one = new IntWritable(1);
        private Text location = new Text();

        //Map lines into key value of (location, one)
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                location.set(tokenizer.nextToken());
                output.collect(location, one);
            }
        }
    }

    //Reduce to (location, sum(values))
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            output.collect(key, new IntWritable(sum));
        }
    }

    public static void main(String[] args) {

    }
}