package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;

    public Picked(Delivery aggregate) {
        super(aggregate);
    }

    public Picked() {
        super();
    }
}
