package com.clean_arch_enablers.exception_handlers;

import com.cae.mapped_exceptions.specifics.InputMappedException;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.mapped_exceptions.specifics.NotFoundMappedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    static final Integer BAD_REQUEST = 400;
    static final Integer NOT_FOUND = 404;
    static final Integer NOT_SUPPORTED_MEDIA_TYPE = 415;
    static final Integer SERVER_ERROR = 500;

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(InputMappedException inputMappedException){
        return ResponseEntity.status(BAD_REQUEST).body(HandlerMessage.of(inputMappedException));
    }

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(NotFoundMappedException notFoundMappedException){
        return ResponseEntity.status(NOT_FOUND).body(HandlerMessage.of(notFoundMappedException));
    }

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(InternalMappedException internalMappedException){
        return ResponseEntity.status(SERVER_ERROR).body(HandlerMessage.of(internalMappedException));
    }

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(MissingRequestHeaderException missingRequestHeaderException){
        return ResponseEntity.status(BAD_REQUEST).body(HandlerMessage.of(missingRequestHeaderException));
    }

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(MissingServletRequestParameterException missingServletRequestParameterException){
        return ResponseEntity.status(BAD_REQUEST).body(HandlerMessage.of(missingServletRequestParameterException));
    }

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(HttpMediaTypeNotSupportedException httpMediaTypeNotSupportedException){
        return ResponseEntity.status(NOT_SUPPORTED_MEDIA_TYPE).body(HandlerMessage.of(httpMediaTypeNotSupportedException));
    }

    @ExceptionHandler
    public ResponseEntity<HandlerMessage> handle(Exception unexpectedException){
        return ResponseEntity.status(SERVER_ERROR).body(HandlerMessage.of(unexpectedException));
    }

}
