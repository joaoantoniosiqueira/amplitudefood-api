package br.com.amplitude.amplitudefood.api.mapper;

import br.com.amplitude.amplitudefood.api.model.input.StateInput;
import br.com.amplitude.amplitudefood.domain.entity.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State stateInputToState(StateInput stateInput);
}
