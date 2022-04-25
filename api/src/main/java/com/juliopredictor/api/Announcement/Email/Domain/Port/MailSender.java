package com.juliopredictor.api.Announcement.Email.Domain.Port;

import com.juliopredictor.api.Announcement.Email.Domain.Model.NotificationEmail;

public interface MailSender {
    void sendMail(NotificationEmail notificationEmail);
}
