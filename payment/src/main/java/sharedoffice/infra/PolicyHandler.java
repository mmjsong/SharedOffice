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
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationCacelRequested'")
    public void wheneverReservationCacelRequested_CancelPaymentPayment(@Payload ReservationCacelRequested reservationCacelRequested){

        ReservationCacelRequested event = reservationCacelRequested;
        System.out.println("\n\n##### listener CancelPaymentPayment : " + reservationCacelRequested + "\n\n");


        

        // Sample Logic //
        Payment.cancelPaymentPayment(event);
        

        

    }

}


