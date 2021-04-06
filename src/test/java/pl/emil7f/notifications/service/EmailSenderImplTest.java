package pl.emil7f.notifications.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.emil7f.notifications.dto.EmailDto;

@SpringBootTest
public class EmailSenderImplTest {

    @Autowired
    EmailSender emailSender;


    @Test
    public void sendEmailTest() {
        EmailDto emailDto = EmailDto.builder()
                .to("emil7f7@gmail.com")
                .title("title")
                .content("content")
                .build();
        emailSender.sendEmail(emailDto);
    }
}
