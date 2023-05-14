package hello.kafka.v3;

import hello.kafka.v1.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka/v3")
public class KafkaControllerV3 {
    private final KafkaProducerV3 producer;

    @Autowired
    public KafkaControllerV3(KafkaProducerV3 producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendMessage(@RequestParam("message") String message){
        this.producer.sendMessage(message);
        return "success";
    }


}
