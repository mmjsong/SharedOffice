package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OfficeDeleted extends AbstractEvent {

    private String officeId;
    private String status;
    private String desc;
    private int reviewCnt;
    private String lastAction;

    public OfficeDeleted(Office aggregate){
        super(aggregate);
    }
    public OfficeDeleted(){
        super();
    }
}
