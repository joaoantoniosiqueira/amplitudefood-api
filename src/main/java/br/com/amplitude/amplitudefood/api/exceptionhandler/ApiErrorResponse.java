package br.com.amplitude.amplitudefood.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder
public class ApiErrorResponse {

    private OffsetDateTime timestamp;
    private int status;
    private String title;
    private String path;
    private String userMessage;
    private String errorMessage;
}
