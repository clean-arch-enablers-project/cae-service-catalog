package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports;

import com.cae.ports.specifics.functions.FunctionPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public abstract class GPTIntegrationPort extends FunctionPort<GPTIntegrationPort.Input, GPTIntegrationPort.Output> {

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Input{
        private String sourceCode;
    }

    @AllArgsConstructor
    @Getter
    public static class Output{
        private final String description;
    }

}
