package hello.kafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * 해당 클래스는 V1에서 Producer에서 단순 위임하는 코드를 삭제.
 * 설정 파일만 설정한뒤 컨트롤러에서 주입을 받아서 해당 단에서 처리를 한다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka/v2")
@Slf4j
public class KafkaControllerV2 {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic myTopic1;
    private final NewTopic myTopic2;

    @GetMapping("/publish/mytopic1")
    public String publishSpringTopic1(){
        String message = "publish message to my_topic_1" + UUID.randomUUID();
        try {
            CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(myTopic1.name(), message);
            log.info("Send Message = {} with offset = {}",message,send.get().getRecordMetadata().offset());
        }catch (Exception e){
            log.info("fail to send myTopic1 = {}",e.getMessage());
        }
        return "success";
    }

    @GetMapping("/publish/mytopic2")
    public String publishSpringTopic2(){
        String message = "publish message to my_topic_2" + UUID.randomUUID();
        try {
            CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(myTopic2.name(), message);
            log.info("Send Message = {} with offset = {}",message,send.get().getRecordMetadata().offset());
        }catch (Exception e){
            log.info("fail to send myTopic2");
        }
        return "success";
    }

}
