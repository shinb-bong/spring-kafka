package hello.kafka;

import hello.kafka.v3.KafkaConfigV3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(KafkaConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.kafka.v3")
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
