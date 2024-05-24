package com.clean.arch.enablers.cae.doc.file.collector.assemblers.logger;

import com.cae.loggers.IOLoggingMode;
import com.cae.loggers.LoggerProvider;
import com.clean.arch.enablers.cae.doc.file.collector.adapters.logger.LoggerAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggerBootstrap {

    public static void startupLoggerConfigs(){
        LoggerProvider.SINGLETON
                .setProvidedInstance(LoggerAdapter.SINGLETON)
                .setIOLoggingMode(IOLoggingMode.CAE_NATIVE)
                .setPortsLoggingIO(true)
                .setUseCasesLoggingIO(false)
                .async(false)
                .structuredFormat(true);
    }

}
