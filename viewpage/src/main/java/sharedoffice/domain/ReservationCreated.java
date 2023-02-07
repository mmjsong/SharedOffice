package sharedoffice.domain;

import lombok.Data;
import sharedoffice.infra.AbstractEvent;


@Data
public class ReservationCreated extends AbstractEvent {

    private String rsvId;
    private String officeId;
    private String status;
    private String payId;

    public String getRsvId(){
        return rsvId;
    }
}
