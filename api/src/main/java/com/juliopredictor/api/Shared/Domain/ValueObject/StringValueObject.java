package com.juliopredictor.api.Shared.Domain.ValueObject;

public abstract class StringValueObject {

    private final String value;

    protected StringValueObject(String value) {
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
