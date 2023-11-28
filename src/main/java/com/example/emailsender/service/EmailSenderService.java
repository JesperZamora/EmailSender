package com.example.emailsender.service;


import com.example.emailsender.model.EmailMessage;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {

    //void sendEmail(String toEmail, String replyEmail, String subject, String message);
    void sendEmail(EmailMessage emailMessage);


    void sendMailMime(EmailMessage mail) throws MessagingException;
}
