package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryMenu'"
    )
    public void wheneverDeliveryMenu_CanSearch(
        @Payload DeliveryMenu deliveryMenu
    ) {
        DeliveryMenu event = deliveryMenu;
        System.out.println(
            "\n\n##### listener CanSearch : " + deliveryMenu + "\n\n"
        );

        // Sample Logic //
        Order.canSearch(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Finish'"
    )
    public void wheneverFinish_CanSearch(@Payload Finish finish) {
        Finish event = finish;
        System.out.println("\n\n##### listener CanSearch : " + finish + "\n\n");

        // Sample Logic //
        Order.canSearch(event);
    }
}
