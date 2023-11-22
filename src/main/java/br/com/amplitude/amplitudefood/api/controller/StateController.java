package br.com.amplitude.amplitudefood.api.controller;

import br.com.amplitude.amplitudefood.api.mapper.StateMapper;
import br.com.amplitude.amplitudefood.api.mapper.StateModelMapper;
import br.com.amplitude.amplitudefood.api.model.StateModel;
import br.com.amplitude.amplitudefood.api.model.input.StateInput;
import br.com.amplitude.amplitudefood.domain.entity.State;
import br.com.amplitude.amplitudefood.domain.service.StateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/states")
public class StateController {

    private final StateModelMapper stateModelMapper;
    private final StateMapper stateMapper;
    private final StateService stateService;

    @GetMapping("/{stateId}")
    public StateModel findById(@PathVariable Long stateId) {
        State state = stateService.findById(stateId);
        return stateModelMapper.stateToStateModel(state);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StateModel save(@RequestBody @Valid StateInput stateInput) {
        State newState = stateMapper.stateInputToState(stateInput);
        newState = stateService.save(newState);

        return stateModelMapper.stateToStateModel(newState);
    }
}
