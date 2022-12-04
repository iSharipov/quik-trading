package com.quik.model.converter;

import com.quik.model.Signal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringToSignalConverterTest {

    private StringToSignalConverter underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringToSignalConverter();
    }

    @Test
    void testStringToSignalConverter() {
        //when
        Signal signal = underTest.convert("1");
        //then
        Assertions.assertNotNull(signal);
    }

    @Test
    void testExpectedException() {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            underTest.convert("one");
        }, "NumberFormatException was expected");

        Assertions.assertEquals("For input string: \"one\"", thrown.getMessage());
    }
}