package com.camilo.demo_sqs.recibebox;

import com.camilo.demo_sqs.Notifications.NotificationToEmailRecoveryPassword;
import com.camilo.demo_sqs.common.NotificationTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Consumer {

    @Autowired
    private ObjectMapper objectMapper;

    @SqsListener(value = "spring_queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS) // value -topic
    public void processMessage(String payload) {

        try {
            NotificationTemplate msg = objectMapper.readValue(payload, NotificationToEmailRecoveryPassword.class);

            log.info(msg.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}