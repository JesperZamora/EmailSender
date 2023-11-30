package com.example.emailsender.service.impl;

import com.example.emailsender.model.AutoReply;
import com.example.emailsender.model.CustomerMessage;
import com.example.emailsender.model.EmailMessage;
import com.example.emailsender.service.EmailSenderService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    @Value("${email}")
    private String fromMail;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.mailSender = javaMailSender;
    }


    //The method below is a walmart version of the email-sender. It's a basic, scrapped version.
    @Override
    public void sendEmail(EmailMessage mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);

        mailMessage.setReplyTo(mail.getReply());

        mailMessage.setTo(mail.getTo());

        mailMessage.setSubject(mail.getSubject());

        mailMessage.setText(mail.getMessage());

        this.mailSender.send(mailMessage);
    }

    //Make a try-catch instead for this method
    public void sendMailMime(EmailMessage mail) throws MessagingException {
        //CustomerMessage is a custom class that contains the html and css. Information received from customer.
        CustomerMessage customerMessage = new CustomerMessage();
        customerMessage.setReply(mail.getReply());
        customerMessage.setSubject(mail.getSubject());
        customerMessage.setNumber(mail.getNumber());
        customerMessage.setMessage(mail.getMessage());

        //MimeMessage is a class in the JavaMail API that represents an email message.
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

        message.setFrom(fromMail);
        message.setTo(fromMail);
        message.setReplyTo(mail.getReply());
        message.setSubject(mail.getSubject());
        message.setText(customerMessage.buildCustomerMessage(), true);

        mailSender.send(mimeMessage);

        //Sends reply message to customer confirming the mail has been received.
        //AutoReply is a custom class that holds the html and css for an auto reply to the customer.
        AutoReply autoReply = new AutoReply();

        message.setReplyTo(fromMail);
        message.setTo(mail.getReply());
        message.setSubject(autoReply.autoReplySubjectField() + mail.getSubject());
        message.setText(autoReply.buildAutoReply(), true);

        mailSender.send(mimeMessage);
    }
}
