package com.juliopredictor.api.Announcement.Email.Application.validateEmail.Adapter;

import com.juliopredictor.api.Announcement.Email.Domain.Port.MailSender;
import com.juliopredictor.api.Announcement.Email.Domain.Model.NotificationEmail;
import com.juliopredictor.api.Announcement.Email.Infrastructure.Gateway.SpringJavaMailer;

public class MailSenderAdapter implements MailSender {

    private final SpringJavaMailer springJavaMailer;

    public MailSenderAdapter(SpringJavaMailer springJavaMailer) {
        this.springJavaMailer = springJavaMailer;
    }

    public void sendMail(NotificationEmail notificationEmail){
        springJavaMailer.sendMail(notificationEmail);
    }
}
