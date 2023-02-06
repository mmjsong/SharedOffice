package sharedoffice.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private String payId;
    private String rsvId;
    private String officeId;
    private String status;
}


