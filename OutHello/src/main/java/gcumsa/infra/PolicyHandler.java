package gcumsa.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import gcumsa.config.kafka.KafkaProcessor;
import gcumsa.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    WorldRepository worldRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Hello'"
    )
    public void wheneverHello_Helloworld(@Payload Hello hello) {
        Hello event = hello;
        System.out.println("\n\n##### listener Helloworld : " + hello + "\n\n");
        // Sample Logic //

    }
}
