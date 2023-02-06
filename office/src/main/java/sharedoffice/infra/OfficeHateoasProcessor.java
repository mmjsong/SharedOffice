package sharedoffice.infra;
import sharedoffice.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OfficeHateoasProcessor implements RepresentationModelProcessor<EntityModel<Office>>  {

    @Override
    public EntityModel<Office> process(EntityModel<Office> model) {

        
        return model;
    }
    
}
