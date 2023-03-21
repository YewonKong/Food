package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RideHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Ride>> {

    @Override
    public EntityModel<Ride> process(EntityModel<Ride> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/finish")
                .withRel("finish")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/regi")
                .withRel("regi")
        );

        return model;
    }
}
