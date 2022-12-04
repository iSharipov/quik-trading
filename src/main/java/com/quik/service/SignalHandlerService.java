package com.quik.service;

import com.quik.algo.SignalHandler;
import com.quik.model.Signal;
import com.quik.strategy.TradingStrategy;
import com.quik.strategy.TradingStrategyFactory;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerService implements SignalHandler {

    private final TradingStrategyFactory tradingStrategyFactory;

    public SignalHandlerService(TradingStrategyFactory tradingStrategyFactory) {
        this.tradingStrategyFactory = tradingStrategyFactory;
    }

    @Override
    public void handleSignal(int signal) {
        TradingStrategy strategy = tradingStrategyFactory.findStrategy(Signal.getFromInt(signal).orElse(Signal.DEFAULT));
        strategy.execute();
    }
}
