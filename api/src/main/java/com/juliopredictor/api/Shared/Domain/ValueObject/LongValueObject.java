package com.juliopredictor.api.Shared.Domain.ValueObject;

public abstract class LongValueObject {

    private final Long value;

    protected LongValueObject(Long value) {
        this.value = value;
    }

    public Long value() {
        return this.value;
    }

    public Boolean isBiggerThan(LongValueObject otherLongValueObject){
        return this.value() > otherLongValueObject.value();
    }
}
