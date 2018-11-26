package signal.emitter.factory;

public interface KafkaSettings {
    String KAFKA_BROKERS = "localhost:9092";
    String CLIENT_ID = "Beacon_emitter";
    String TOPIC_1_NAME = "test1";
    String TOPIC_2_NAME = "test2";
    String TOPIC_3_NAME = "test3";
}
