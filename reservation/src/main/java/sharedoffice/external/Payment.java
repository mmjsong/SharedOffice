package sharedoffice.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long payId;
    private Long rsvId;
    private String officeId;
    private String status;
}


