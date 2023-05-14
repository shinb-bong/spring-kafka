package hello.kafka.v3;

import hello.kafka.v3.StockChange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerV3 {
    private final NewTopic stockTopic;
    private final KafkaTemplate<String, StockChange> kafkaTemplate;

    public void sendMessage(String message) {

        StockChange stockChange = StockChange.builder()
                .date(LocalDate.now())
                .message(message)
                .skuCd("10300000033")
                .fieldName("ipgoNo")
                .diff(100)
                .build();

        log.info("Send StockChange = {}", stockChange);
        // Send a message
        kafkaTemplate.send(stockTopic.name(), stockChange);
    }
}
