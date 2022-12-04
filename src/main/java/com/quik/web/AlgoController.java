package com.quik.web;

import com.quik.algo.SignalHandler;
import com.quik.model.Signal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/algo")
public class AlgoController {

    private final SignalHandler signalHandler;

    public AlgoController(SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
    }

    @PostMapping("/{signalId}/execute")
    public void doAlgo(@PathVariable Signal signalId) {
        signalHandler.handleSignal(signalId.getSignalId());
    }
}
