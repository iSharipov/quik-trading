package com.quik.strategy;

import com.quik.algo.Algo;
import com.quik.model.Signal;
import org.springframework.stereotype.Service;

@Service
public class DefaultStrategy implements TradingStrategy {
    @Override
    public void execute() {
        final Algo algo = new Algo();
        algo.cancelTrades();
    }

    @Override
    public Signal getSignal() {
        return Signal.DEFAULT;
    }
}
