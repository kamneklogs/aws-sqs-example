package com.camilo.demo_sqs.sendbox;

import com.camilo.demo_sqs.common.MessageTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Publisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Scheduled(fixedRate = 1000)
    public void pushToQueue(MessageTemplate notification) {
        log.info("Sending message...");

        try {

            queueMessagingTemplate.convertAndSend(endpoint, notification);
            log.info("Message sended");

        } catch (Exception e) {
            log.info("Message not sended");

            e.printStackTrace();
        }

    }
}
