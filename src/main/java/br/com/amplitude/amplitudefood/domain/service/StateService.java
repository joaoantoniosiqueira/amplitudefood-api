package br.com.amplitude.amplitudefood.domain.service;

import br.com.amplitude.amplitudefood.domain.entity.State;
import br.com.amplitude.amplitudefood.domain.repository.StateRepository;
import br.com.amplitude.amplitudefood.exception.StateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StateService {

    private final StateRepository stateRepository;

    public State findById(Long stateId) {
        return stateRepository
                .findById(stateId)
                .orElseThrow(() -> new StateNotFoundException(String.format("State not found for the provided ID: %d", stateId)));
    }
}
