package com.quik.strategy;

import com.quik.model.Signal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class TradingStrategyFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradingStrategyFactory.class);

    private final Set<TradingStrategy> tradingStrategies;
    private Map<Signal, TradingStrategy> strategies;

    public TradingStrategyFactory(Set<TradingStrategy> tradingStrategies) {
        this.tradingStrategies = tradingStrategies;
    }

    @PostConstruct
    private void init() {
        createStrategy(tradingStrategies);
        LOGGER.debug("Number of strategies: {}", tradingStrategies.size());
    }

    public TradingStrategy findStrategy(Signal signal) {
        TradingStrategy tradingStrategy = strategies.get(signal);
        LOGGER.debug("Trading strategy: {}", tradingStrategy.getSignal().getSignalId());
        return tradingStrategy;
    }

    private void createStrategy(Set<TradingStrategy> strategySet) {
        strategies = new HashMap<>(strategySet.size());
        strategySet.forEach(
                strategy -> strategies.put(strategy.getSignal(), strategy));
    }
}
