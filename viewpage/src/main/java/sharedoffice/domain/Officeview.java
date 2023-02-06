package sharedoffice.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="Officeview_table")
@Data
public class Officeview {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long officeId;
        private Integer desc;
        private Date reviewCnt;
        private String rsvId;
        private String rsvStatus;
        private String payId;
        private String payStatus;


}
