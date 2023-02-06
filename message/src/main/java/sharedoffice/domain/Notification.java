package sharedoffice.domain;

import sharedoffice.MessageApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Notification_table")
@Data

public class Notification  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long msgId;
    
    
    
    
    
    private String rsvId;
    
    
    
    
    
    private Date sendDate;
    
    
    
    
    
    private String content;
    
    
    
    
    
    private String officeId;


    public static NotificationRepository repository(){
        NotificationRepository notificationRepository = MessageApplication.applicationContext.getBean(NotificationRepository.class);
        return notificationRepository;
    }




    public static void sendConfirmMsg(ReservationConfirmed reservationConfirmed){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationConfirmed.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void sendCancelMsg(ReservationCancelled reservationCancelled){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelled.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }


}
