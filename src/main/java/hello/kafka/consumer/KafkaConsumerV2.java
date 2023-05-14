package hello.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerV2 {

    @KafkaListener(topics = "#{myTopic1.name}",groupId = "group1")
    public void consumeMyTopic1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition){
        log.info("[consume message Group1] : {} from partition : {}", message, partition);
    }
    @KafkaListener(topics = "#{myTopic2.name}",groupId = "group1")
    public void consumeMyTopic2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition){
        log.info("[consume message] : {} from partition : {}", message, partition);
    }

    // 현재는 같은 그룹이여서
    // 다른 프로세스를 실행시키고 그룹 아이디를 바꿔주면 독립된 offset 보장

}
