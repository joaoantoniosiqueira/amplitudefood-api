package br.com.amplitude.amplitudefood.api.factory;

import br.com.amplitude.amplitudefood.api.model.StateModel;
import br.com.amplitude.amplitudefood.domain.entity.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StateModelFactory {

    public StateModel fromState(State state) {
        return new StateModel(state.getId(), state.getName());
    }
}
