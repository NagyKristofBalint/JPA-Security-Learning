package edu.nagy.jpa_security_learning.api.errorhandling;

import edu.nagy.jpa_security_learning.api.dto.outgoing.SimpleMessageDTO;
import edu.nagy.jpa_security_learning.api.dto.outgoing.SimpleMessagesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collection;

@Slf4j
@RestControllerAdvice
public class LearningExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleMessagesDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: {}", e.getMessage());
        Collection<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(it -> it.getField() + " " + it.getDefaultMessage()).toList();
        return new SimpleMessagesDTO(errors);
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleMessagesDTO handleApiException(ApiException e) {
        log.error("ApiException: {}", e.getMessage());
        return new SimpleMessagesDTO(e.getMessage().lines().toList());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFoundException(NotFoundException e) {
        log.error("NotFoundException: {}", e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleMessageDTO handleBadRequestException(BadRequestException e) {
        log.error("BadRequestException: {}", e.getMessage());
        return new SimpleMessageDTO(e.getMessage());
    }
}
