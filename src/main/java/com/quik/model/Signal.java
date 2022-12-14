package com.quik.model;

import java.util.Arrays;
import java.util.Optional;

public enum Signal {

    SIGNAL_1(1),
    SIGNAL_2(2),
    SIGNAL_3(3),
    DEFAULT(-1);

    private final int signalId;

    Signal(int signalId) {
        this.signalId = signalId;
    }

    public int getSignalId() {
        return signalId;
    }

    public static Optional<Signal> getFromString(String signalId) {
        return Arrays.stream(Signal.values())
                .filter(v -> v.getSignalId() == Integer.parseInt(signalId))
                .findFirst();
    }

    public static Optional<Signal> getFromInt(int signalId) {
        return Arrays.stream(Signal.values())
                .filter(v -> v.getSignalId() == signalId)
                .findFirst();
    }
}
