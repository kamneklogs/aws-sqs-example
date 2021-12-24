package com.camilo.demo_sqs;

import com.camilo.demo_sqs.Notifications.NotificationToEmailRecoveryPassword;
import com.camilo.demo_sqs.sendbox.Publisher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = DemoSqsApplication.class)
class DemoSqsApplicationTests {

	@Autowired
	private Publisher publisher;

	@Test
	void sendMsg() {

		NotificationToEmailRecoveryPassword n = new NotificationToEmailRecoveryPassword("kamnelogs@gmail.com",
				"Password recovery code", "38788hgunxu1h8h28mx9");

		publisher.pushToQueue(n);

	}

}
