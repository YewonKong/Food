package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class WriteStatus extends AbstractEvent {

    private Long id;
    private String cutomerId;
    private String menu;
    private String status;

    public WriteStatus(Cooking aggregate) {
        super(aggregate);
    }

    public WriteStatus() {
        super();
    }
}
