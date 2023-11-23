package br.com.amplitude.amplitudefood.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class ApiErrorResponse {

    private OffsetDateTime timestamp;
    private int status;
    private String title;
    private String path;
    private String userMessage;
    private String errorMessage;

    private List<Field> fields;

    @Builder
    @Getter
    public static class Field {
        private String field;
        private String description;
    }
}
