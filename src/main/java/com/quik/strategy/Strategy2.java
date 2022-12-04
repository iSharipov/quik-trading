package com.quik.strategy;

import com.quik.algo.Algo;
import com.quik.model.Signal;

public class Strategy2 implements TradingStrategy {
    @Override
    public void execute() {
        final Algo algo = new Algo();
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
    }

    @Override
    public Signal getSignal() {
        return Signal.SIGNAL_2;
    }
}
