package com.juliopredictor.api.Announcement.Email.Application.validateEmail.Service;

import com.juliopredictor.api.Announcement.Email.Domain.Model.EmailRequest;
import com.juliopredictor.api.Announcement.Email.Domain.Port.MailSender;
import com.juliopredictor.api.Announcement.Email.Domain.Model.NotificationEmail;

public class MailSenderServiceImplementation implements MailSenderService {

    private final MailSender mailSender;

    public MailSenderServiceImplementation(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(EmailRequest emailRequest) {
        NotificationEmail notificationEmail = new NotificationEmail(
                "Please Activate your Account",
                emailRequest.getEmail(),
                String.format("Thanks you for sign up to Spring Accounting Web Application," +
                                " please click on the below url to activate your account : " +
                                "http://localhost:8080/api/signup/token/%s",
                        emailRequest.getToken()));
        mailSender.sendMail(notificationEmail);
    }
}
