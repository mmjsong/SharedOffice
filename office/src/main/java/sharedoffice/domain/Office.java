package sharedoffice.domain;

import sharedoffice.domain.OfficeRegistered;
import sharedoffice.domain.OfficeModified;
import sharedoffice.domain.OfficeDeleted;
import sharedoffice.domain.OfficeReserved;
import sharedoffice.domain.OfficeCancelled;
import sharedoffice.OfficeApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Office_table")
@Data

public class Office  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long officeId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String desc;
    
    
    
    
    
    private String reviewCnt;
    
    
    
    
    
    private String lastAction;

    @PostPersist
    public void onPostPersist(){


        OfficeRegistered officeRegistered = new OfficeRegistered(this);
        officeRegistered.publishAfterCommit();



        OfficeModified officeModified = new OfficeModified(this);
        officeModified.publishAfterCommit();



        OfficeDeleted officeDeleted = new OfficeDeleted(this);
        officeDeleted.publishAfterCommit();



        OfficeReserved officeReserved = new OfficeReserved(this);
        officeReserved.publishAfterCommit();



        OfficeCancelled officeCancelled = new OfficeCancelled(this);
        officeCancelled.publishAfterCommit();

    }

    public static OfficeRepository repository(){
        OfficeRepository officeRepository = OfficeApplication.applicationContext.getBean(OfficeRepository.class);
        return officeRepository;
    }




    public static void confirmReserve(ReservationConfirmed reservationConfirmed){

        /** Example 1:  new item 
        Office office = new Office();
        repository().save(office);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationConfirmed.get???()).ifPresent(office->{
            
            office // do something
            repository().save(office);


         });
        */

        
    }
    public static void cancel(ReservationCancelled reservationCancelled){

        /** Example 1:  new item 
        Office office = new Office();
        repository().save(office);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelled.get???()).ifPresent(office->{
            
            office // do something
            repository().save(office);


         });
        */

        
    }
    public static void updateReviewCnt(ReviewCreated reviewCreated){

        /** Example 1:  new item 
        Office office = new Office();
        repository().save(office);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewCreated.get???()).ifPresent(office->{
            
            office // do something
            repository().save(office);


         });
        */

        
    }
    public static void updateReviewCnt(ReviewDeleted reviewDeleted){

        /** Example 1:  new item 
        Office office = new Office();
        repository().save(office);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewDeleted.get???()).ifPresent(office->{
            
            office // do something
            repository().save(office);


         });
        */

        
    }


}
