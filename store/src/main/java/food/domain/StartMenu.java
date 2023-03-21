package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StartMenu extends AbstractEvent {

    private Long id;
    private String menu;

    public StartMenu(Cooking aggregate) {
        super(aggregate);
    }

    public StartMenu() {
        super();
    }
}
