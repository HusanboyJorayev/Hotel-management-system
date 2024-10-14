package org.example.hotel_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailSenderServiceImpl {
    private final JavaMailSender mailSender;


    public String sendCodeToMail(String mail) {
        Random random = new Random();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("husanboybackanddeveloper@gmail.com");
        message.setTo(mail);
        int i = random.nextInt(1000, 9999);
        String code = Integer.toString(i);
        message.setSubject("GRAND HOTEL MANAGEMENT SYSTEM " +
                "  YOUR VERIFICATION CODE => " + code);
        message.setText(code);
        mailSender.send(message);
        return code;
    }
}
