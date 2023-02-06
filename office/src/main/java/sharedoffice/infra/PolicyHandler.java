package sharedoffice.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import sharedoffice.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import sharedoffice.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired OfficeRepository officeRepository;
    @Autowired ReviewRepository reviewRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationConfirmed'")
    public void wheneverReservationConfirmed_ConfirmReserve(@Payload ReservationConfirmed reservationConfirmed){

        ReservationConfirmed event = reservationConfirmed;
        System.out.println("\n\n##### listener ConfirmReserve : " + reservationConfirmed + "\n\n");


        

        // Sample Logic //
        Office.confirmReserve(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationCancelled'")
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        ReservationCancelled event = reservationCancelled;
        System.out.println("\n\n##### listener Cancel : " + reservationCancelled + "\n\n");


        

        // Sample Logic //
        Office.cancel(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewCreated'")
    public void wheneverReviewCreated_UpdateReviewCnt(@Payload ReviewCreated reviewCreated){

        ReviewCreated event = reviewCreated;
        System.out.println("\n\n##### listener UpdateReviewCnt : " + reviewCreated + "\n\n");


        

        // Sample Logic //
        Office.updateReviewCnt(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewDeleted'")
    public void wheneverReviewDeleted_UpdateReviewCnt(@Payload ReviewDeleted reviewDeleted){

        ReviewDeleted event = reviewDeleted;
        System.out.println("\n\n##### listener UpdateReviewCnt : " + reviewDeleted + "\n\n");


        

        // Sample Logic //
        Office.updateReviewCnt(event);
        

        

    }

}


