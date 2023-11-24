package br.com.amplitude.amplitudefood.api.controller;

import br.com.amplitude.amplitudefood.api.mapper.StateMapper;
import br.com.amplitude.amplitudefood.api.mapper.StateModelMapper;
import br.com.amplitude.amplitudefood.api.model.StateModel;
import br.com.amplitude.amplitudefood.api.model.input.StateInput;
import br.com.amplitude.amplitudefood.domain.entity.State;
import br.com.amplitude.amplitudefood.domain.service.StateService;
import br.com.amplitude.amplitudefood.exception.ResourceInUseException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/states")
public class StateController {

    private final StateModelMapper stateModelMapper;
    private final StateMapper stateMapper;
    private final StateService stateService;

    @GetMapping("/{stateId}")
    public ResponseEntity<StateModel> findById(@PathVariable Long stateId) {
        State state = stateService.findById(stateId);
        return ResponseEntity.ok(stateModelMapper.stateToStateModel(state));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StateModel save(@RequestBody @Valid StateInput stateInput) {
        State newState = stateMapper.stateInputToState(stateInput);
        newState = stateService.save(newState);

        return stateModelMapper.stateToStateModel(newState);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{stateId}")
    public void deleteById(@PathVariable Long stateId) {
        try {
            stateService.deleteById(stateId);
        } catch (DataIntegrityViolationException ex) {
            throw new ResourceInUseException(String.format("The state with ID: %d cannot be removed as it is currently in use.", stateId));
        }
    }

    @PutMapping("/{stateId}")
    public ResponseEntity<StateModel> update(@PathVariable Long stateId, @RequestBody @Valid StateInput stateInput) {
        State stateForUpdate = stateService.findById(stateId);
        stateMapper.updateStateFromStateInput(stateInput, stateForUpdate);

        State stateUpdated = stateService.save(stateForUpdate);
        return ResponseEntity.ok(stateModelMapper.stateToStateModel(stateUpdated));
    }
}
