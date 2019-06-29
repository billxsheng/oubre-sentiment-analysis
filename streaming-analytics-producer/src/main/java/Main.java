import producer.TwitterKafkaProducer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Streaming Analytics");
        TwitterKafkaProducer producer = new TwitterKafkaProducer();
        producer.run();
    }
}
