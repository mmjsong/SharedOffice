package sharedoffice.domain;

import sharedoffice.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class ReservationCancelled extends AbstractEvent {

    private String rsvId;
    private String officeId;
    private String status;
    private String payId;
}
