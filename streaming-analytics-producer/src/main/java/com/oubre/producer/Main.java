package com.oubre.producer;

import com.oubre.producer.kafka.TwitterKafkaProducer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("Core").log(Level.INFO, "Twitter Streaming Analytics!");
        TwitterKafkaProducer producer = new TwitterKafkaProducer();
        producer.run();
    }
}
