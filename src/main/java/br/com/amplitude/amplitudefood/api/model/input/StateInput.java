package br.com.amplitude.amplitudefood.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateInput {

    @NotBlank
    private String name;
}
