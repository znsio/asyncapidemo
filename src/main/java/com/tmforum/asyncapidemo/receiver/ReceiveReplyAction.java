package com.tmforum.asyncapidemo.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReceiveReplyAction {
    @Autowired
    KafkaTemplate<Integer, Object> kafkaTemplate;

    @KafkaListener(topics = "troubleTicket.v5.createTroubleTicket.commandReply", groupId = "troubleTicketDemo")
    public void listenCreateTroubleTicketRequest(@Payload String message, @Header("X-Correlation-Id") String correlationId) {
        System.out.println("Received Create Trouble Ticket Reply with correlationId: " + correlationId + " and payload " + message);
    }
}
