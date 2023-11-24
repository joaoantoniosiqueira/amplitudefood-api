package br.com.amplitude.amplitudefood.exception;

public class ResourceInUseException extends ApiErrorException {

    public ResourceInUseException(String message) {
        super(message);
    }
}
