package hello.kafka.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerV3 {
    // 컨슈머 컨테이너팩토리를 명시해주어야함.
    @KafkaListener(topics = "stock", groupId = "foo", containerFactory = "stockChangeListener")
    public void consume(StockChange stockChange) {
        log.info("Receive Data = {}", stockChange.getDate());
        log.info("Receive Message = {}", stockChange.getMessage());
    }
}
