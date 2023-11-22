package br.com.amplitude.amplitudefood.api.mapper;

import br.com.amplitude.amplitudefood.api.model.StateModel;
import br.com.amplitude.amplitudefood.domain.entity.State;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface StateModelMapper {

    StateModel stateToStateModel(State state);
}
