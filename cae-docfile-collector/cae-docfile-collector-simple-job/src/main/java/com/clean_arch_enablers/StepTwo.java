package com.clean_arch_enablers;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae_docfile_collector.assemblers.logger.LoggerBootstrap;
import com.clean.arch.enablers.cae_docfile_collector.assemblers.use_cases.handle_new_docfile.HandleNewDocfileUseCaseAssembler;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.HandleNewDocfileUseCase;

public class StepTwo {

    static final HandleNewDocfileUseCase USE_CASE = HandleNewDocfileUseCaseAssembler.SINGLETON_ASSEMBLER.getDefaultAssembledInstance();

    public static void main(String[] args) {
        LoggerBootstrap.startupLoggerConfigs();
        USE_CASE.execute(UseCaseExecutionCorrelation.ofNew());
    }
}