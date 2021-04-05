package pl.emil7f.notifications.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderImplTest {

    @Autowired
    EmailSender emailSender;


    @Test
    public void sendEmailTest() {
        emailSender.sendEmail("emil7f7@gmail.com", "Witaj", "hello");
    }
}
