package com.juliopredictor.api.Announcement.Email.Application.validateEmail.Service;

import com.juliopredictor.api.Announcement.Email.Domain.Model.EmailRequest;

public interface MailSenderService {
    void sendMail(EmailRequest emailRequest);
}
