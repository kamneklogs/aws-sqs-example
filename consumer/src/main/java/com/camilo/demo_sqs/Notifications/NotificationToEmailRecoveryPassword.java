package com.camilo.demo_sqs.Notifications;

import com.camilo.demo_sqs.common.NotificationTemplate;

public class NotificationToEmailRecoveryPassword extends NotificationTemplate {

    public NotificationToEmailRecoveryPassword(final String emailAddress, final String subject, final String content) {

        data.put("email", emailAddress);
        data.put("subject", subject);
        data.put("content", content);

    }

}
