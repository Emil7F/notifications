package pl.emil7f.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.emil7f.notifications.dto.NotificationInfoDto;

@Service
public class RabbitMQListener {

    Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "enroll_finish")
    public void handleFinishEnroll(NotificationInfoDto notificationInfo) {
    logger.info(notificationInfo.toString());

    }
}
