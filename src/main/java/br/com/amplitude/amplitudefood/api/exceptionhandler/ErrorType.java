package br.com.amplitude.amplitudefood.api.exceptionhandler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorType {
    ENTITY_NOT_FOUND("entityNotFoundTitle", "entityNotFoundMessage"),
    INVALID_DATA("invalidDataTitle", "entityNotFoundMessage"),
    ARGUMENT_TYPE_MISMATCH("argumentTypeMismatchTitle", "argumentTypeMismatchMessage"),
    METHOD_NOT_ALLOWED("methodNotAllowedTitle", "methodNotAllowedMessage"),
    RESOURCE_IN_USE("resourceInUseTitle", "resourceInUseMessage");

    private final String title;
    private final String genericDetail;
}
