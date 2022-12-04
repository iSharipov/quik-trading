package com.quik.strategy;

import com.quik.algo.Algo;
import com.quik.model.Signal;
import com.quik.web.AlgoController;
import org.springframework.stereotype.Service;

@Service
public class Strategy1 implements TradingStrategy {
    @Override
    public void execute() {
        final Algo algo = new Algo();
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
    }

    @Override
    public Signal getSignal() {
        return Signal.SIGNAL_1;
    }
}
