package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReviewModified extends AbstractEvent {

    private Long reviewId;
    private String officeId;
    private String content;

    public ReviewModified(Review aggregate){
        super(aggregate);
    }
    public ReviewModified(){
        super();
    }
}
