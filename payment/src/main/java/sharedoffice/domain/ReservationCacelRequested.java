package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ReservationCacelRequested extends AbstractEvent {

    private Long rsvId;
    private String officeId;
    private String status;
    private String payId;
}


