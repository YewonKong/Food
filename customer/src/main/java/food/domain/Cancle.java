package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cancle extends AbstractEvent {

    private Long id;
    private String orderId;
    private String store;
    private String menu;
    private String cancleId;

    public Cancle(Order aggregate) {
        super(aggregate);
    }

    public Cancle() {
        super();
    }
}
