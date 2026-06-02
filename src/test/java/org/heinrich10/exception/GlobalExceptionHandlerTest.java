package org.heinrich10.exception;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import jakarta.validation.ConstraintViolationException;
import org.heinrich10.dto.responses.ErrorResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleNotFoundReturns404() {
        HttpRequest<?> request = mock(HttpRequest.class);
        when(request.getPath()).thenReturn("/persons/999");

        HttpResponse<ErrorResponse> response = handler.handleNotFound(request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());
        assertNotNull(response.body());
        assertEquals(404, response.body().status());
        assertEquals("Not Found", response.body().error());
        assertTrue(response.body().message().contains("/persons/999"));
    }

    @Test
    void handleConstraintViolationReturns400() {
        HttpRequest<?> request = mock(HttpRequest.class);
        ConstraintViolationException exception = new ConstraintViolationException("must not be blank", null);

        HttpResponse<ErrorResponse> response = handler.handleConstraintViolation(request, exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());
        assertNotNull(response.body());
        assertEquals(400, response.body().status());
        assertEquals("Bad Request", response.body().error());
        assertEquals("must not be blank", response.body().message());
    }

    @Test
    void handleBadRequestReturns400() {
        HttpRequest<?> request = mock(HttpRequest.class);

        HttpResponse<ErrorResponse> response = handler.handleBadRequest(request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());
        assertNotNull(response.body());
        assertEquals(400, response.body().status());
        assertEquals("Bad Request", response.body().error());
    }

    @Test
    void handleExceptionReturns500() {
        HttpRequest<?> request = mock(HttpRequest.class);
        when(request.getPath()).thenReturn("/persons");
        RuntimeException exception = new RuntimeException("DB is down");

        HttpResponse<ErrorResponse> response = handler.handleException(request, exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatus());
        assertNotNull(response.body());
        assertEquals(500, response.body().status());
        assertEquals("Internal Server Error", response.body().error());
    }
}
