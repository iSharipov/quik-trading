package com.quik.model.converter;

import com.quik.model.Signal;
import org.springframework.core.convert.converter.Converter;

public class StringToSignalConverter implements Converter<String, Signal> {

    @Override
    public Signal convert(String signalId) {
        return Signal.getFromString(signalId).orElse(Signal.DEFAULT);
    }
}
