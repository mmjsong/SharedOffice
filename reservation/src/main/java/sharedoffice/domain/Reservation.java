package sharedoffice.domain;

import sharedoffice.domain.ReservationCreated;
import sharedoffice.domain.ReservationCacelRequested;
import sharedoffice.domain.ReservationConfirmed;
import sharedoffice.domain.ReservationCancelled;
import sharedoffice.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Reservation_table")
@Data

public class Reservation  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long rsvId;
    
    
    
    
    
    private String officeId;
    
    
    
    
    
    private String status;
    
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long payId;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        sharedoffice.external.Office office = new sharedoffice.external.Office();
        // mappings goes here
        ReservationApplication.applicationContext.getBean(sharedoffice.external.OfficeService.class)
            .chkAndReqReserve(office);


        ReservationCreated reservationCreated = new ReservationCreated(this);
        
        reservationCreated.publishAfterCommit();



        ReservationCacelRequested reservationCacelRequested = new ReservationCacelRequested(this);
        reservationCacelRequested.publishAfterCommit();



        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(this);
        reservationConfirmed.publishAfterCommit();



        ReservationCancelled reservationCancelled = new ReservationCancelled(this);
        reservationCancelled.publishAfterCommit();

    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }




    public static void confirmReserve(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

       

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);


         });
        */

        
    }
    public static void confirmCancel(PaymentCancelled paymentCancelled){
       System.out.println("#########################################################################################");
        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

        // Reservation res = new Reservation();
        // res.setRsvId(paymentCancelled.getRsvId());
        // res.setPayId(paymentCancelled.getPayId());
        // res.setOfficeId(paymentCancelled.getOfficeId());
        // res.setStatus("취소완료");

        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);


         });
        */

        repository().findById(paymentCancelled.getPayId()).ifPresent(reservation->{
            System.out.println("\n\n############### 취소 #########" + reservation.toString());
            reservation.setStatus("취소완료");
            reservation.setRsvId(paymentCancelled.getRsvId());
            reservation.setOfficeId(paymentCancelled.getOfficeId());
            repository().save(reservation);
             

         });

        
    }
    public static void reservationCreated(ReservationCreated reserverationCreated){

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */
            // 새 객체 생성
        Reservation res = new Reservation();
        res.setRsvId(reserverationCreated.getRsvId());
        res.setOfficeId(reserverationCreated.getOfficeId());
        res.setPayId(reserverationCreated.getPayId());
        res.setStatus("요청완료");
        repository().save(res);
        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);


         });
        */
         // 
        // repository().findById(reserverationCreated.getRsvId()).ifPresent(reservation->{
            
        //     reservation.setStatus("요청완료");
        //     reservation.setRsvId(reservation.getRsvId());
        //     reservation.setOfficeId(reservation.getOfficeId());
        //     repository().save(reservation);


        //  });

        
    }


}
