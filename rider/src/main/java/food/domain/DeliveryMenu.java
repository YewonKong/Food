package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryMenu extends AbstractEvent {

    private Long id;
    private String orderId;
    private String menu;
    private String address;

    public DeliveryMenu(Ride aggregate) {
        super(aggregate);
    }

    public DeliveryMenu() {
        super();
    }
}
