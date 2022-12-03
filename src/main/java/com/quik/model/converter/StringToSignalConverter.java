package com.quik.model.converter;

import com.quik.model.InvalidTradingStrategy;
import com.quik.model.Signal;
import org.springframework.core.convert.converter.Converter;

public class StringToSignalConverter implements Converter<String, Signal> {

    @Override
    public Signal convert(String signalId) {
        return Signal.getFromInt(signalId).orElseThrow(
                () -> new InvalidTradingStrategy("No corresponding trading strategy"));
    }
}
