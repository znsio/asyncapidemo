package com.tmforum.asyncapidemo.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class SendRequestAction {
    @Autowired
    KafkaTemplate<Integer, Object> kafkaTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    public void publishMessage() {
        ProducerRecord<Integer, Object> record = new ProducerRecord<>("troubleTicket.v5.createTroubleTicket.commandRequest", null, null, messagePayload());
        record.headers().add(new RecordHeader("X-Correlation-Id", UUID.randomUUID().toString().getBytes()));
        record.headers().add(new RecordHeader("Reply-Channel", "troubleTicket.v5.createTroubleTicket.commandReply".getBytes()));
        kafkaTemplate.send(record);
    }

    private String messagePayload() {
        try {
            return new ObjectMapper().readTree(resourceLoader.getResource("classpath:createTroubleTicketPayload.json").getFile()).findValue("payload").toPrettyString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
