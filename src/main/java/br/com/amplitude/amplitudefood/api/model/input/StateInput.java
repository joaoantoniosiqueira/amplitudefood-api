package br.com.amplitude.amplitudefood.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateInput {

    @Size(min = 3, max = 150)
    @NotBlank
    private String name;
}
