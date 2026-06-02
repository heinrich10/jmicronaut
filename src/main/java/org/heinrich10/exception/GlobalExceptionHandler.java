package org.heinrich10.exception;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import jakarta.validation.ConstraintViolationException;
import org.heinrich10.dto.responses.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Error(global = true, status = HttpStatus.NOT_FOUND)
    public HttpResponse<ErrorResponse> handleNotFound(HttpRequest<?> request) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.getCode(),
                "Not Found",
                "The requested resource was not found: " + request.getPath()
        );
        return HttpResponse.notFound(error);
    }

    @Error(global = true, exception = ConstraintViolationException.class)
    public HttpResponse<ErrorResponse> handleConstraintViolation(HttpRequest<?> request, ConstraintViolationException exception) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.getCode(),
                "Bad Request",
                exception.getMessage()
        );
        return HttpResponse.badRequest(error);
    }

    @Error(global = true, status = HttpStatus.BAD_REQUEST)
    public HttpResponse<ErrorResponse> handleBadRequest(HttpRequest<?> request) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.getCode(),
                "Bad Request",
                "The request could not be understood or was missing required parameters."
        );
        return HttpResponse.badRequest(error);
    }

    @Error(global = true, exception = Exception.class)
    public HttpResponse<ErrorResponse> handleException(HttpRequest<?> request, Exception exception) {
        LOG.error("Unhandled exception for request {}: {}", request.getPath(), exception.getMessage(), exception);
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.getCode(),
                "Internal Server Error",
                "An unexpected error occurred. Please try again later."
        );
        return HttpResponse.serverError(error);
    }
}
