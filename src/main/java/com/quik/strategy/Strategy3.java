package com.quik.strategy;

import com.quik.algo.Algo;
import com.quik.model.Signal;

public class Strategy3 implements TradingStrategy {
    @Override
    public void execute() {
        final Algo algo = new Algo();
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }

    @Override
    public Signal getSignal() {
        return Signal.SIGNAL_3;
    }
}
