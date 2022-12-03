package com.quik.web;

import com.quik.model.Signal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/algo")
public class AlgoController {

    @PostMapping("/{signalId}/execute")
    public void doAlgo(@PathVariable Signal signalId) {

    }
}
