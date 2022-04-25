package com.juliopredictor.api.Shared.Infrastructure.Delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {

    private Integer statusCode;
    private String status;
    private String message;
    private T body;

    public RestResponse(HttpStatus httpStatus, T body){
        this.statusCode = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.body = body;
    }

    public RestResponse(HttpStatus httpStatus, String message){
        this.statusCode = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.message = message;
    }

    public RestResponse(HttpStatus httpStatus, String message, T body){
        this.statusCode = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.message = message;
        this.body = body;
    }
}
