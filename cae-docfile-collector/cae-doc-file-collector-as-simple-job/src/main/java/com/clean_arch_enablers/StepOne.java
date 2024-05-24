package com.clean_arch_enablers;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.assemblers.logger.LoggerBootstrap;
import com.clean.arch.enablers.cae.doc.file.collector.assemblers.use_cases.handle_old_doc_file.HandleOldDocFileUseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_old_doc_file.HandleOldDocFileUseCase;

public class StepOne {

    static final HandleOldDocFileUseCase USE_CASE = HandleOldDocFileUseCaseAssembler.SINGLETON_ASSEMBLER.getDefaultAssembledInstance();

    public static void main(String[] args) {
        LoggerBootstrap.startupLoggerConfigs();
        USE_CASE.execute(UseCaseExecutionCorrelation.ofNew());
    }

}
