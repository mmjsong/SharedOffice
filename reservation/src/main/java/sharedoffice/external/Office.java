package sharedoffice.external;

import lombok.Data;
import java.util.Date;
@Data
public class Office {

    private Long officeId;
    private String status;
    private String desc;
    private String reviewCnt;
    private String lastAction;
}


