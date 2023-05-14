package hello.kafka.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "exam", groupId = "foo")
    public void consume(String message){
        log.info("Consumed message = {}",message);
    }
}
