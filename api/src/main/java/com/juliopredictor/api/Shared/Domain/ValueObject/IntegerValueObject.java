package com.juliopredictor.api.Shared.Domain.ValueObject;

public abstract class IntegerValueObject {

    private final Integer value;

    protected IntegerValueObject(Integer value) {
        this.value = value;
    }

    public Integer value(){
        return this.value;
    }

    public Boolean isBiggerThan(IntegerValueObject otherIntegerValueObject){
        return this.value() > otherIntegerValueObject.value();
    }
}
