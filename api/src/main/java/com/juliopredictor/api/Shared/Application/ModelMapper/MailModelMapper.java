package com.juliopredictor.api.Shared.Application.ModelMapper;

import com.juliopredictor.api.Announcement.Email.Domain.Model.EmailRequest;

public class MailModelMapper {

    public EmailRequest toEmailRequest(String email, String token){
        return new EmailRequest(email, token);
    }
}
