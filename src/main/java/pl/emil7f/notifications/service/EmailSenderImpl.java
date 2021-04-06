package pl.emil7f.notifications.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.emil7f.notifications.dto.EmailDto;
import pl.emil7f.notifications.dto.NotificationInfoDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {


    private final JavaMailSender javaMailSender;

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmails(NotificationInfoDto notificationInfo) {
        String title = "Remember about course " + notificationInfo.getCourseName();
        String content = createEmailContent(notificationInfo);
        notificationInfo.getEmails().forEach(email -> sendEmail(email, title, content));
    }

    private String createEmailContent(NotificationInfoDto notificationInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append("Course ");
        builder.append(notificationInfo.getCourseName());
        builder.append(" begin ");
        builder.append(notificationInfo.getCourseStartDate().toLocalDate());
        builder.append(" at: ");
        builder.append(notificationInfo.getCourseStartDate().getHour()).append(":").append(notificationInfo.getCourseStartDate().getMinute());
        builder.append(".");
        return builder.toString();
    }

    @Override
    public void sendEmail(EmailDto emailDto) {
        sendEmail(emailDto.getTo(), emailDto.getTitle(), emailDto.getContent());
    }

    private void sendEmail(String to, String title, String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(title);
            mimeMessageHelper.setText(content, false);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
