package pl.emil7f.notifications.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.emil7f.notifications.dto.EmailDto;
import pl.emil7f.notifications.service.EmailSender;

import javax.validation.Valid;

@RestController
public class EmailController {
    private final EmailSender emailSender;

    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }


    @PostMapping("/email")
    public String sendEmail(@RequestBody @Valid EmailDto emailDto) {
        emailSender.sendEmail(emailDto);
        return "Email send: " + emailDto.getTo();
    }

}
