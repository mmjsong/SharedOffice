package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OfficeReserved extends AbstractEvent {

    private Long officeId;
    private String status;
    private String desc;
    private int reviewCnt;
    private String lastAction;

    public OfficeReserved(Office aggregate){
        super(aggregate);
    }
    public OfficeReserved(){
        super();
    }
}
