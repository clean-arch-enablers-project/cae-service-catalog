package com.clean_arch_enablers.exception_handlers;

import com.cae.mapped_exceptions.specifics.InputMappedException;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.mapped_exceptions.specifics.NotFoundMappedException;
import com.clean.arch.enablers.cae.doc.file.management.adapters.loggers.LoggerAdapter;
import lombok.Getter;
import org.springframework.util.MimeType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Getter
public class HandlerMessage {

    private HandlerMessage(String message){
        this.message = message;
        LoggerAdapter.SINGLETON.logInfo(message);
    }

    public static HandlerMessage of(InputMappedException inputMappedException){
        return new HandlerMessage(inputMappedException.getMessage());
    }

    public static HandlerMessage of(NotFoundMappedException notFoundMappedException){
        return new HandlerMessage(notFoundMappedException.getMessage());
    }

    public static HandlerMessage of(InternalMappedException internalMappedException){
        return new HandlerMessage(internalMappedException.getBriefPublicMessage());
    }

    public static HandlerMessage of(MissingRequestHeaderException missingRequestHeaderException) {
        return new HandlerMessage("Header missing: " + missingRequestHeaderException.getHeaderName());
    }

    public static HandlerMessage of(MissingServletRequestParameterException missingServletRequestParameterException) {
        return new HandlerMessage("Query parameter missing: " + missingServletRequestParameterException.getParameterName() + " (type: " + missingServletRequestParameterException.getParameterType() + ")");
    }

    public static HandlerMessage of(HttpMediaTypeNotSupportedException httpMediaTypeNotSupportedException) {
        return new HandlerMessage("Not supported media type received. Accepted ones: " + httpMediaTypeNotSupportedException.getSupportedMediaTypes().stream().map(MimeType::getType).reduce("", (previous, next) -> previous.concat(", ".concat(next))));
    }

    public static HandlerMessage of(Exception unexpectedException) {
        return new HandlerMessage("Something went unexpectedly wrong: " + unexpectedException);
    }

    public final String message;

}
