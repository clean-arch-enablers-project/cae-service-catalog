package com.clean.arch.enablers.cae.doc.file.management.adapters.loggers;

import com.cae.loggers.Logger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggerAdapter implements Logger {

    public static final Logger SINGLETON = new LoggerAdapter();

    @Override
    public void logInfo(String info) {
        log.info(info);
    }

    @Override
    public void logError(String error) {
        log.error(error);
    }

    @Override
    public void logDebug(String info) {
        log.debug(info);
    }
}
