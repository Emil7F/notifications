package pl.emil7f.notifications.service;

import pl.emil7f.notifications.dto.NotificationInfoDto;

public interface EmailSender {

    void sendEmails(NotificationInfoDto notificationInfo);

    void sendEmail(String to, String title, String content);
}
