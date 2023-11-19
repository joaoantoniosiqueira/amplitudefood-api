package br.com.amplitude.amplitudefood.api.controller;

import br.com.amplitude.amplitudefood.api.factory.StateModelFactory;
import br.com.amplitude.amplitudefood.api.model.StateModel;
import br.com.amplitude.amplitudefood.domain.entity.State;
import br.com.amplitude.amplitudefood.domain.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/states")
public class StateController {

    private final StateModelFactory stateModelFactory;
    private final StateService stateService;

    @GetMapping("/{stateId}")
    public StateModel findById(@PathVariable Long stateId) {
        State state = stateService.findById(stateId);
        return stateModelFactory.fromState(state);
    }
}
