package com.juliopredictor.api.Announcement.Email.Domain.Exception;

import com.juliopredictor.api.Shared.Domain.DomainError;

public class ErrorOccurredWhenSendingEmailException extends DomainError {

    public ErrorOccurredWhenSendingEmailException(String personToSend){
        super("error_occurred_when_sending_email", String.format("Exception occurred when sending mail to %s", personToSend));
    }
}