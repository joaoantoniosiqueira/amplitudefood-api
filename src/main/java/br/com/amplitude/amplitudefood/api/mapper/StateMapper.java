package br.com.amplitude.amplitudefood.api.mapper;

import br.com.amplitude.amplitudefood.api.model.input.StateInput;
import br.com.amplitude.amplitudefood.domain.entity.State;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StateMapper {

    State stateInputToState(StateInput stateInput);

    @Mapping(target = "id", ignore = true)
    void updateStateFromStateInput(StateInput stateInput, @MappingTarget State state);
}
