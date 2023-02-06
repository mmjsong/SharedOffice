package sharedoffice.domain;

import sharedoffice.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class PaymentApproved extends AbstractEvent {

    private String payId;
    private String rsvId;
    private String officeId;
    private String status;
}
