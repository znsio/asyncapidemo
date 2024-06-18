package com.tmforum.asyncapidemo.notifications;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationAction {
    @KafkaListener(topics = "troubleTicket.v5.troubleTicket.notificationEvent", groupId = "troubleTicketDemo")
    public void listenCreateTroubleTicketRequestNotification(String message) {
        System.out.println("Notification received for trouble ticket creation " + message);
    }
}
