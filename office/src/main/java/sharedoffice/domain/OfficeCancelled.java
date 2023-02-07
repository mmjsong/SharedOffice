package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OfficeCancelled extends AbstractEvent {

    private String officeId;
    private String status;
    private String desc;
    private int reviewCnt;
    private String lastAction;

    public OfficeCancelled(Office aggregate){
        super(aggregate);
    }
    public OfficeCancelled(){
        super();
    }
}
