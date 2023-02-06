package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private String payId;
    private String rsvId;
    private String officeId;
    private String status;

    public PaymentCancelled(Payment aggregate){
        super(aggregate);
    }
    public PaymentCancelled(){
        super();
    }
}
