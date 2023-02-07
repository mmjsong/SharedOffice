package sharedoffice.domain;

import sharedoffice.domain.PaymentApproved;
import sharedoffice.domain.PaymentCancelled;
import sharedoffice.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Payment_table")
@Data

public class Payment  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String payId;
    
    
    
    
    
    private String rsvId;
    
    
    
    
    
    private String officeId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();



        PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        paymentCancelled.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }




    public static void cancelPaymentPayment(ReservationCacelRequested reservationCacelRequested){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */
        
        Payment payment = new Payment();
        payment.setRsvId(reservationCacelRequested.getRsvId());
        payment.setPayId(reservationCacelRequested.getPayId());
        payment.setStatus("결제취소");
        repository().save(payment);

        /** Example 2:  finding and process
        
        repository().findById(reservationCacelRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        repository().findById(reservationCacelRequested.getRsvId()).ifPresent(cancelledPayment -> {
            cancelledPayment.setStatus(reservationCacelRequested.getStatus());
            cancelledPayment.setPayId(reservationCacelRequested.getPayId());
            cancelledPayment.setRsvId(reservationCacelRequested.getRsvId());
            repository().save(cancelledPayment);
        });

        
    }


}
