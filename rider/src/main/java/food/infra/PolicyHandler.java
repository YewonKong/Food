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
    RideRepository rideRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StartMenu'"
    )
    public void wheneverStartMenu_LoadDeliveryInfo(
        @Payload StartMenu startMenu
    ) {
        StartMenu event = startMenu;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + startMenu + "\n\n"
        );

        // Sample Logic //
        Ride.loadDeliveryInfo(event);
    }
}
