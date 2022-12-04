package com.quik.strategy;

import com.quik.model.Signal;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class TradingStrategyFactory {
    private final Set<TradingStrategy> tradingStrategies;
    private Map<Signal, TradingStrategy> strategies;

    public TradingStrategyFactory(Set<TradingStrategy> tradingStrategies) {
        this.tradingStrategies = tradingStrategies;
    }

    @PostConstruct
    private void init() {
        createStrategy(tradingStrategies);
    }

    public TradingStrategy findStrategy(Signal signal) {
        return strategies.get(signal);
    }

    private void createStrategy(Set<TradingStrategy> strategySet) {
        strategies = new HashMap<>(strategySet.size());
        strategySet.forEach(
                strategy -> strategies.put(strategy.getSignal(), strategy));
    }
}
