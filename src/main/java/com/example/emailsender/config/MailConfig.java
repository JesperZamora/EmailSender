package com.example.emailsender.config;

import jakarta.mail.internet.MimeMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

//This is class is not in use, it was just to see if springboot would handle the injection, and it did.
public class MailConfig {
/*
    @Bean
    public MimeMessage javaMailSender(JavaMailSender mailSender) {
        return mailSender.createMimeMessage();
    }

 */

}
