package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Replaced extends AbstractEvent {

    private Long id;

    public Replaced(Cooking aggregate) {
        super(aggregate);
    }

    public Replaced() {
        super();
    }
}
