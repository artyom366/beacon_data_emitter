package signal.emitter.service;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import signal.emitter.factory.KafkaProducerFactory;
import signal.emitter.factory.KafkaSettings;

import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@Service
public class KafkaServiceImpl implements KafkaService {

    private final EmitterService emitterService;

    @Autowired
    public KafkaServiceImpl(final EmitterService emitterService) {
        this.emitterService = emitterService;
    }

    @Override
    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void run() {

        try (final Producer<Long, String> producer = KafkaProducerFactory.createProducer()) {

            Stream.of(KafkaSettings.TOPIC_1_NAME, KafkaSettings.TOPIC_2_NAME, KafkaSettings.TOPIC_3_NAME).forEach(topic -> {
                final String jsonRecord = emitterService.emit();
                final ProducerRecord<Long, String> record = new ProducerRecord<>(topic, jsonRecord);

                try {
                    final RecordMetadata recordMetadata = producer.send(record).get();
                    System.out.printf("\nMetadata received: %s, partition: %d, offset: %s, topic: %s\n",
                            recordMetadata.toString(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.topic());

                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);

                } finally {
                    producer.flush();
                }
            });
        }
    }
}
