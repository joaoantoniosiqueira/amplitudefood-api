package br.com.amplitude.amplitudefood.exception;

public class ApiErrorException extends ApplicationException {
    public ApiErrorException(String message) {
        super(message);
    }
}
