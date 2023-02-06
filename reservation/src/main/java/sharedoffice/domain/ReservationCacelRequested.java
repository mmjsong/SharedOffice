package sharedoffice.domain;

import sharedoffice.domain.*;
import sharedoffice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReservationCacelRequested extends AbstractEvent {

    private Long rsvId;
    private String officeId;
    private String status;
    private String payId;

    public ReservationCacelRequested(Reservation aggregate){
        super(aggregate);
    }
    public ReservationCacelRequested(){
        super();
    }
}
