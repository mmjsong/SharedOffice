package sharedoffice.infra;

import sharedoffice.domain.*;
import sharedoffice.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OfficeviewViewHandler {

    @Autowired
    private OfficeviewRepository officeviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCreated_then_CREATE_1 (@Payload ReservationCreated reservationCreated) {
        try {

            if (!reservationCreated.validate()) return;

            // view 객체 생성
            Officeview officeview = new Officeview();
            // view 객체에 이벤트의 Value 를 set 함
            officeview.setOfficeId(Long.valueOf(reservationCreated.getOfficeId()));
            officeview.setRsvId(String.valueOf(reservationCreated.getRsvId()));
            officeview.setRsvStatus("예약신청");
            // view 레파지 토리에 save
            officeviewRepository.save(officeview);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_1(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회

                List<Officeview> officeviewList = officeviewRepository.findByRsvId(paymentApproved.getRsvid());
                for(Officeview officeview : officeviewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    officeview.setRsvStatus("예약완료");
                // view 레파지 토리에 save
                officeviewRepository.save(officeview);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_DELETE_1(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            officeviewRepository.deleteByRsvId(reservationCancelled.getRsvId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

