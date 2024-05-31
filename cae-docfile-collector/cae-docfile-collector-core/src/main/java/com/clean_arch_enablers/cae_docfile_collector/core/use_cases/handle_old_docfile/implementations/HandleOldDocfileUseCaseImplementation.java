package com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_old_docfile.implementations;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean_arch_enablers.cae_docfile_collector.core.entities.factories.DocfileCollectorFactory;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_old_docfile.HandleOldDocfileUseCase;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class HandleOldDocfileUseCaseImplementation extends HandleOldDocfileUseCase {

    @Override
    protected void applyInternalLogic(UseCaseExecutionCorrelation useCaseExecutionCorrelation) {
        var docFile = DocfileCollectorFactory.SINGLETON.makeNewInstance();
        docFile.moveOldDocToTemporaryLocation();
    }
}