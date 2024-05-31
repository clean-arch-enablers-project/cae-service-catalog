package com.clean.arch.enablers.cae.doc.file.management.assemblers.loggers;

import com.cae.loggers.IOLoggingMode;
import com.cae.loggers.LoggerProvider;
import com.clean.arch.enablers.cae.doc.file.management.adapters.loggers.LoggerAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggerBootstrap {

    public static void startupSettings(){
        LoggerProvider.SINGLETON
                .setProvidedInstance(LoggerAdapter.SINGLETON)
                .structuredFormat(true)
                .setUseCasesLoggingIO(true)
                .setPortsLoggingIO(true)
                .setIOLoggingMode(IOLoggingMode.CAE_NATIVE)
                .async(false);
    }

}
