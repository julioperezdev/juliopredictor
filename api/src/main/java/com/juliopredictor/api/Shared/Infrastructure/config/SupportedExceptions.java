package com.juliopredictor.api.Shared.Infrastructure.config;

import com.juliopredictor.api.Announcement.Email.Domain.Exception.ErrorOccurredWhenSendingEmailException;
import com.juliopredictor.api.Shared.Domain.DomainError;
import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    //Categories Controller Exceptions
    //..

    //CourseCreatorEndpoints Exceptions
    ERROR_OCCURRED_WHEN_SENDING_EMAIL(ErrorOccurredWhenSendingEmailException.class, HttpStatus.PRECONDITION_FAILED);

    //CourseCreatorAdapterRepository Exceptions
    //COURSE_DOES_NOT_RECORDED(CourseDoesNotRecordedException.class, HttpStatus.BAD_GATEWAY),
    //COURSE_CAN_NOT_HAVE_SAME_NAME(CourseCanNotHaveSameNameException.class, HttpStatus.PRECONDITION_REQUIRED);


    private Class<? extends DomainError> exceptionClass;
    private HttpStatus status;
    private SupportedExceptions(Class<? extends DomainError>exception, HttpStatus status){
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class <? extends DomainError> getExceptionClass(){
        return this.exceptionClass;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}
