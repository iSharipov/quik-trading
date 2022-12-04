package com.quik.strategy;

import com.quik.model.Signal;

public interface TradingStrategy {
    void execute();

    Signal getSignal();
}
