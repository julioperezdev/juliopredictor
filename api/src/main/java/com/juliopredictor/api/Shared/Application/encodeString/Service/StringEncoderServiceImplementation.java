package com.juliopredictor.api.Shared.Application.encodeString.Service;

import com.juliopredictor.api.Shared.Application.encodeString.Adapter.StringEncoderAdapter;

public class StringEncoderServiceImplementation implements StringEncoderService{

    private final StringEncoderAdapter stringEncoderAdapter;

    public StringEncoderServiceImplementation(StringEncoderAdapter stringEncoderAdapter) {
        this.stringEncoderAdapter = stringEncoderAdapter;
    }

    public String encodeString(String stringToEncode){
        return stringEncoderAdapter.encodeString(stringToEncode);
    }
}
