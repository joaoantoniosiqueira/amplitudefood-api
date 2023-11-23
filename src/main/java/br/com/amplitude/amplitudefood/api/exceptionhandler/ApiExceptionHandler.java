package br.com.amplitude.amplitudefood.api.exceptionhandler;

import br.com.amplitude.amplitudefood.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiErrorResponse apiErrorResponse = createApiErrorResponseBuilder(HttpStatus.METHOD_NOT_ALLOWED, ErrorType.METHOD_NOT_ALLOWED, request)
                .errorMessage(String.format("Request method %s not supported. The methods supported are: %s", ex.getMethod(), Arrays.toString(ex.getSupportedMethods())))
                .build();

        return handleExceptionInternal(ex, apiErrorResponse, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiErrorResponse apiErrorResponse = createApiErrorResponseBuilder(HttpStatus.BAD_REQUEST, ErrorType.ARGUMENT_TYPE_MISMATCH, request)
                .errorMessage(String.format("Failed to convert the value '%s' to the parameter named '%s' which expects the type '%s'. Please review and try again.", ex.getValue(), ex.getPropertyName(), ex.getRequiredType().getName()))
                .build();

        return handleExceptionInternal(ex, apiErrorResponse, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;
        ApiErrorResponse errorResponse = createApiErrorResponseBuilder(notFoundStatus, ErrorType.ENTITY_NOT_FOUND, request)
                .errorMessage(ex.getMessage())
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), notFoundStatus, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ApiErrorResponse.Field> fieldsError = extractFieldsError(ex);

        HttpStatus badRequestStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiErrorResponse = createApiErrorResponseBuilder(badRequestStatus, ErrorType.INVALID_DATA, request)
                .fields(fieldsError).build();

        return handleExceptionInternal(ex, apiErrorResponse, headers, badRequestStatus, request);
    }

    private List<ApiErrorResponse.Field> extractFieldsError(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    String errorDescription = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                    return ApiErrorResponse.Field.builder()
                            .field(fieldError.getField())
                            .description(errorDescription)
                            .build();
                }).collect(Collectors.toList());
    }

    private ApiErrorResponse.ApiErrorResponseBuilder createApiErrorResponseBuilder(HttpStatus status, ErrorType errorType, WebRequest request) {
        String title = messageSource.getMessage(errorType.getTitle(), null, LocaleContextHolder.getLocale());
        String userMessage = messageSource.getMessage(errorType.getGenericDetail(), null, LocaleContextHolder.getLocale());

        return ApiErrorResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .title(title)
                .path(request.getDescription(false).replace("uri=", ""))
                .userMessage(userMessage);
    }
}
