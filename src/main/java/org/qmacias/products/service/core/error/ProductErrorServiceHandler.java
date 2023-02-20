package org.qmacias.products.service.core.error;

import org.axonframework.commandhandling.CommandExecutionException;

import org.qmacias.products.service.core.FormatLocalDateTimeUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ProductErrorServiceHandler {

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException e, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                FormatLocalDateTimeUtil.getActualFormattedLocalDateTime(), e.getLocalizedMessage()
        );
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {CommandExecutionException.class})
    public ResponseEntity<Object> handleCommandExecutionException(CommandExecutionException e, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                FormatLocalDateTimeUtil.getActualFormattedLocalDateTime(), e.getLocalizedMessage()
        );
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception e, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), e.getLocalizedMessage()
        );
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
