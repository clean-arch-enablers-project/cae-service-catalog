package com.clean_arch_enablers;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.assemblers.logger.LoggerBootstrap;
import com.clean.arch.enablers.cae.doc.file.collector.assemblers.use_cases.handle_new_doc_file.HandleNewDocFileUseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.HandleNewDocFileUseCase;

public class StepTwo {

    static final HandleNewDocFileUseCase USE_CASE = HandleNewDocFileUseCaseAssembler.SINGLETON_ASSEMBLER.getDefaultAssembledInstance();

    public static void main(String[] args) {
        LoggerBootstrap.startupLoggerConfigs();
        USE_CASE.execute(UseCaseExecutionCorrelation.ofNew());
    }
}