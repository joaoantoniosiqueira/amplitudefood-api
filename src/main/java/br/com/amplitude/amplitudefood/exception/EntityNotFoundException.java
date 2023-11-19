package br.com.amplitude.amplitudefood.exception;

public class EntityNotFoundException extends ApiErrorException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
